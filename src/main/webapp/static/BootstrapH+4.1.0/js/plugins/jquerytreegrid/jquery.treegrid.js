/*
 * jQuery treegrid Plugin 0.3.0
 * https://github.com/maxazan/jquery-treegrid
 *
 * Copyright 2013, Pomazan Max
 * Licensed under the MIT licenses.
 *陈霖洵 2017-1-6添加LoadData和getSelectedRow函数
 */
(function($) {

    var methods = {
        /**
         * Initialize tree
         *
         * @param {Object} options
         * @returns {Object[]}
         */
        initTree: function(options) {
            var settings = $.extend({}, this.treegrid.defaults, options);
            return this.each(function() {
                var $this = $(this);
                $this.treegrid('setTreeContainer', $(this));
                $this.treegrid('setSettings', settings);
                settings.getRootNodes.apply(this, [$(this)]).treegrid('initNode', settings);
                $this.treegrid('getRootNodes').treegrid('render');
            });
        },
        /**
         * Initialize node
         *
         * @param {Object} settings
         * @returns {Object[]}
         */
        initNode: function(settings) {
            return this.each(function() {
                var $this = $(this);
                $this.treegrid('setTreeContainer', settings.getTreeGridContainer.apply(this));
                $this.treegrid('getChildNodes').treegrid('initNode', settings);
                $this.treegrid('initExpander').treegrid('initIndent').treegrid('initEvents').treegrid('initState').treegrid('initChangeEvent').treegrid("initSettingsEvents");
            });
        },
        initChangeEvent: function() {
            var $this = $(this);
            //Save state on change
            $this.on("change", function() {
                var $this = $(this);
                $this.treegrid('render');
                if ($this.treegrid('getSetting', 'saveState')) {
                    $this.treegrid('saveState');
                }
            });
            return $this;
        },
        /**
         * Initialize node events
         *
         * @returns {Node}
         */
        initEvents: function() {
            var $this = $(this);
            //Default behavior on collapse
            $this.on("collapse", function() {
                var $this = $(this);
                $this.removeClass('treegrid-expanded');
                $this.addClass('treegrid-collapsed');
            });
            //Default behavior on expand
            $this.on("expand", function() {
                var $this = $(this);
                $this.removeClass('treegrid-collapsed');
                $this.addClass('treegrid-expanded');
            });

            return $this;
        },
        /**
         * Initialize events from settings
         *
         * @returns {Node}
         */
        initSettingsEvents: function() {
            var $this = $(this);
            //Save state on change
            $this.on("change", function() {
                var $this = $(this);
                if (typeof($this.treegrid('getSetting', 'onChange')) === "function") {
                    $this.treegrid('getSetting', 'onChange').apply($this);
                }
            });
            //Default behavior on collapse
            $this.on("collapse", function() {
                var $this = $(this);
                if (typeof($this.treegrid('getSetting', 'onCollapse')) === "function") {
                    $this.treegrid('getSetting', 'onCollapse').apply($this);
                }
            });
            //Default behavior on expand
            $this.on("expand", function() {
                var $this = $(this);
                if (typeof($this.treegrid('getSetting', 'onExpand')) === "function") {
                    $this.treegrid('getSetting', 'onExpand').apply($this);
                }

            });

            return $this;
        },
        /**
         * Initialize expander for node
         *
         * @returns {Node}
         */
        initExpander: function() {
            var $this = $(this);
            var cell = $this.find('td').get($this.treegrid('getSetting', 'treeColumn'));
            var tpl = $this.treegrid('getSetting', 'expanderTemplate');
            var expander = $this.treegrid('getSetting', 'getExpander').apply(this);
            if (expander) {
                expander.remove();
            }
            $(tpl).prependTo(cell).click(function() {
                $($(this).closest('tr')).treegrid('toggle');
            });
            return $this;
        },
        /**
         * Initialize indent for node
         *
         * @returns {Node}
         */
        initIndent: function() {
            var $this = $(this);
            $this.find('.treegrid-indent').remove();
            var tpl = $this.treegrid('getSetting', 'indentTemplate');
            var expander = $this.find('.treegrid-expander');
            var depth = $this.treegrid('getDepth');
            for (var i = 0; i < depth; i++) {
                $(tpl).insertBefore(expander);
            }
            return $this;
        },
        /**
         * Initialise state of node
         *
         * @returns {Node}
         */
        initState: function() {
            var $this = $(this);
            if ($this.treegrid('getSetting', 'saveState') && !$this.treegrid('isFirstInit')) {
                $this.treegrid('restoreState');
            } else {
                if ($this.treegrid('getSetting', 'initialState') === "expanded") {
                    $this.treegrid('expand');
                } else {
                    $this.treegrid('collapse');
                }
            }
            return $this;
        },
        /**
         * Return true if this tree was never been initialised
         *
         * @returns {Boolean}
         */
        isFirstInit: function() {
            var tree = $(this).treegrid('getTreeContainer');
            if (tree.data('first_init') === undefined) {
                tree.data('first_init', $.cookie(tree.treegrid('getSetting', 'saveStateName')) === undefined);
            }
            return tree.data('first_init');
        },
        /**
         * Save state of current node
         *
         * @returns {Node}
         */
        saveState: function() {
            var $this = $(this);
            if ($this.treegrid('getSetting', 'saveStateMethod') === 'cookie') {

                var stateArrayString = $.cookie($this.treegrid('getSetting', 'saveStateName')) || '';
                var stateArray = (stateArrayString === '' ? [] : stateArrayString.split(','));
                var nodeId = $this.treegrid('getNodeId');

                if ($this.treegrid('isExpanded')) {
                    if ($.inArray(nodeId, stateArray) === -1) {
                        stateArray.push(nodeId);
                    }
                } else if ($this.treegrid('isCollapsed')) {
                    if ($.inArray(nodeId, stateArray) !== -1) {
                        stateArray.splice($.inArray(nodeId, stateArray), 1);
                    }
                }
                $.cookie($this.treegrid('getSetting', 'saveStateName'), stateArray.join(','));
            }
            return $this;
        },
        /**
         * Restore state of current node.
         *
         * @returns {Node}
         */
        restoreState: function() {
            var $this = $(this);
            if ($this.treegrid('getSetting', 'saveStateMethod') === 'cookie') {
                var stateArray = $.cookie($this.treegrid('getSetting', 'saveStateName')).split(',');
                if ($.inArray($this.treegrid('getNodeId'), stateArray) !== -1) {
                    $this.treegrid('expand');
                } else {
                    $this.treegrid('collapse');
                }

            }
            return $this;
        },
        /**
         * Method return setting by name
         *
         * @param {type} name
         * @returns {unresolved}
         */
        getSetting: function(name) {
            if (!$(this).treegrid('getTreeContainer')) {
                return null;
            }
            return $(this).treegrid('getTreeContainer').data('settings')[name];
        },
        /**
         * Add new settings
         *
         * @param {Object} settings
         */
        setSettings: function(settings) {
            $(this).treegrid('getTreeContainer').data('settings', settings);
        },
        /**
         * Return tree container
         *
         * @returns {HtmlElement}
         */
        getTreeContainer: function() {
            return $(this).data('treegrid');
        },
        /**
         * Set tree container
         *
         * @param {HtmlE;ement} container
         */
        setTreeContainer: function(container) {
            return $(this).data('treegrid', container);
        },
        /**
         * Method return all root nodes of tree.
         *
         * Start init all child nodes from it.
         *
         * @returns {Array}
         */
        getRootNodes: function() {
            return $(this).treegrid('getSetting', 'getRootNodes').apply(this, [$(this).treegrid('getTreeContainer')]);
        },
        /**
         * Method return all nodes of tree.
         *
         * @returns {Array}
         */
        getAllNodes: function() {
            return $(this).treegrid('getSetting', 'getAllNodes').apply(this, [$(this).treegrid('getTreeContainer')]);
        },
        /**
         * Mthod return true if element is Node
         *
         * @returns {String}
         */
        isNode: function() {
            return $(this).treegrid('getNodeId') !== null;
        },
        /**
         * Mthod return id of node
         *
         * @returns {String}
         */
        getNodeId: function() {
            if ($(this).treegrid('getSetting', 'getNodeId') === null) {
                return null;
            } else {
                return $(this).treegrid('getSetting', 'getNodeId').apply(this);
            }
        },
        /**
         * Method return parent id of node or null if root node
         *
         * @returns {String}
         */
        getParentNodeId: function() {
            return $(this).treegrid('getSetting', 'getParentNodeId').apply(this);
        },
        /**
         * Method return parent node or null if root node
         *
         * @returns {Object[]}
         */
        getParentNode: function() {
            if ($(this).treegrid('getParentNodeId') === null) {
                return null;
            } else {
                return $(this).treegrid('getSetting', 'getNodeById').apply(this, [$(this).treegrid('getParentNodeId'), $(this).treegrid('getTreeContainer')]);
            }
        },
        /**
         * Method return array of child nodes or null if node is leaf
         *
         * @returns {Object[]}
         */
        getChildNodes: function() {
            return $(this).treegrid('getSetting', 'getChildNodes').apply(this, [$(this).treegrid('getNodeId'), $(this).treegrid('getTreeContainer')]);
        },
        /**
         * Method return depth of tree.
         *
         * This method is needs for calculate indent
         *
         * @returns {Number}
         */
        getDepth: function() {
            if ($(this).treegrid('getParentNode') === null) {
                return 0;
            }
            return $(this).treegrid('getParentNode').treegrid('getDepth') + 1;
        },
        /**
         * Method return true if node is root
         *
         * @returns {Boolean}
         */
        isRoot: function() {
            return $(this).treegrid('getDepth') === 0;
        },
        /**
         * Method return true if node has no child nodes
         *
         * @returns {Boolean}
         */
        isLeaf: function() {
            return $(this).treegrid('getChildNodes').length === 0;
        },
        /**
         * Method return true if node last in branch
         *
         * @returns {Boolean}
         */
        isLast: function() {
            if ($(this).treegrid('isNode')) {
                var parentNode = $(this).treegrid('getParentNode');
                if (parentNode === null) {
                    if ($(this).treegrid('getNodeId') === $(this).treegrid('getRootNodes').last().treegrid('getNodeId')) {
                        return true;
                    }
                } else {
                    if ($(this).treegrid('getNodeId') === parentNode.treegrid('getChildNodes').last().treegrid('getNodeId')) {
                        return true;
                    }
                }
            }
            return false;
        },
        /**
         * Method return true if node first in branch
         *
         * @returns {Boolean}
         */
        isFirst: function() {
            if ($(this).treegrid('isNode')) {
                var parentNode = $(this).treegrid('getParentNode');
                if (parentNode === null) {
                    if ($(this).treegrid('getNodeId') === $(this).treegrid('getRootNodes').first().treegrid('getNodeId')) {
                        return true;
                    }
                } else {
                    if ($(this).treegrid('getNodeId') === parentNode.treegrid('getChildNodes').first().treegrid('getNodeId')) {
                        return true;
                    }
                }
            }
            return false;
        },
        /**
         * Return true if node expanded
         *
         * @returns {Boolean}
         */
        isExpanded: function() {
            return $(this).hasClass('treegrid-expanded');
        },
        /**
         * Return true if node collapsed
         *
         * @returns {Boolean}
         */
        isCollapsed: function() {
            return $(this).hasClass('treegrid-collapsed');
        },
        /**
         * Return true if at least one of parent node is collapsed
         *
         * @returns {Boolean}
         */
        isOneOfParentsCollapsed: function() {
            var $this = $(this);
            if ($this.treegrid('isRoot')) {
                return false;
            } else {
                if ($this.treegrid('getParentNode').treegrid('isCollapsed')) {
                    return true;
                } else {
                    return $this.treegrid('getParentNode').treegrid('isOneOfParentsCollapsed');
                }
            }
        },
        /**
         * Expand node
         *
         * @returns {Node}
         */
        expand: function() {
            if (!this.treegrid('isLeaf') && !this.treegrid("isExpanded")) {
                this.trigger("expand");
                this.trigger("change");
                return this;
            }
            return this;
        },
        /**
         * Expand all nodes
         *
         * @returns {Node}
         */
        expandAll: function() {
            var $this = $(this);
            $this.treegrid('getRootNodes').treegrid('expandRecursive');
            return $this;
        },
        /**
         * Expand current node and all child nodes begin from current
         *
         * @returns {Node}
         */
        expandRecursive: function() {
            return $(this).each(function() {
                var $this = $(this);
                $this.treegrid('expand');
                if (!$this.treegrid('isLeaf')) {
                    $this.treegrid('getChildNodes').treegrid('expandRecursive');
                }
            });
        },
        /**
         * Collapse node
         *
         * @returns {Node}
         */
        collapse: function() {
            return $(this).each(function() {
                var $this = $(this);
                if (!$this.treegrid('isLeaf') && !$this.treegrid("isCollapsed")) {
                    $this.trigger("collapse");
                    $this.trigger("change");
                }
            });
        },
        /**
         * Collapse all nodes
         *
         * @returns {Node}
         */
        collapseAll: function() {
            var $this = $(this);
            $this.treegrid('getRootNodes').treegrid('collapseRecursive');
            return $this;
        },
        /**
         * Collapse current node and all child nodes begin from current
         *
         * @returns {Node}
         */
        collapseRecursive: function() {
            return $(this).each(function() {
                var $this = $(this);
                $this.treegrid('collapse');
                if (!$this.treegrid('isLeaf')) {
                    $this.treegrid('getChildNodes').treegrid('collapseRecursive');
                }
            });
        },
        /**
         * Expand if collapsed, Collapse if expanded
         *
         * @returns {Node}
         */
        toggle: function() {
            var $this = $(this);
            if ($this.treegrid('isExpanded')) {
                $this.treegrid('collapse');
            } else {
                $this.treegrid('expand');
            }
            return $this;
        },
        /**
         * Rendering node
         *
         * @returns {Node}
         */
        render: function() {
            return $(this).each(function() {
                var $this = $(this);
                //if parent colapsed we hidden
                if ($this.treegrid('isOneOfParentsCollapsed')) {
                    $this.hide();
                } else {
                    $this.show();
                }
                if (!$this.treegrid('isLeaf')) {
                    $this.treegrid('renderExpander');
                    $this.treegrid('getChildNodes').treegrid('render');
                }
            });
        },
        /**
         * Rendering expander depends on node state
         *
         * @returns {Node}
         */
        renderExpander: function() {
            return $(this).each(function() {
                var $this = $(this);
                var expander = $this.treegrid('getSetting', 'getExpander').apply(this);
                if (expander) {

                    if (!$this.treegrid('isCollapsed')) {
                        expander.removeClass($this.treegrid('getSetting', 'expanderCollapsedClass'));
                        expander.addClass($this.treegrid('getSetting', 'expanderExpandedClass'));
                    } else {
                        expander.removeClass($this.treegrid('getSetting', 'expanderExpandedClass'));
                        expander.addClass($this.treegrid('getSetting', 'expanderCollapsedClass'));
                    }
                } else {
                    $this.treegrid('initExpander');
                    $this.treegrid('renderExpander');
                }
            });
        },
        /**
         * 占位符功能
         */
        StringFormat:function()
        {
        	if (arguments.length == 0)
				 return null;
			 var str = arguments[0];
			 for (var i = 1; i < arguments.length; i++) {
				 var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
				 str = str.replace(re, arguments[i]);
			 }
			 return str;
        },
		/*
		*初始化能选中
		*/
		treeGridSelectedInit: function (cName) {
			var className = ".tree",

			rowIndex = 1;//行索引0是表头

			if (cName != undefined) {
				className = cName;
			}

			$(className + " tr").bind('click', function () {
				if ($(this).index() == 0) {
					return;
				}

				$(this).addClass("active");

				if (rowIndex != $(this).index()) {
					$(className + " tr:eq(" + rowIndex + ")").removeClass("active");
				}

				rowIndex = $(this).index();
			});
		},
		//获取选中行数据
		getSelectedRow: function (className)
		{
			if(className==undefined)
			{
				className='.tree';
			}
			//获取选中行
			var selectedTr = null,trClass = "";
			$(className + " tr").each(function () {
				trClass = $(this)[0].className;
				if (trClass.indexOf("active") != -1)
				{
					selectedTr = this;
				}
			});
			if (selectedTr == null)
			{
				return null;
			}

			var rowid=$(selectedTr).attr('id');
			
			var methodThis = function(data){
				var result =null;
				for(var i in data)
				{
					if(data[i][methods.defaults.id]==rowid)
					{
						result = data[i];
					}
					else if(data[i].hasOwnProperty('childrens'))
					{
						result = methodThis(data[i].childrens);
					}
				}
				return result;
			}

			return methodThis(methods.NoteData);
		},
		//根据id获取指定节点数据,没有找到返回空
		getFind:function(id)
		{
			if(id==null)
			{
				return null;
			}
			var data=null;
			
			for(var i in methods.NoteData)
			{
				if(methods.NoteData[i][methods.defaults.id]==id)
				{
					data=methods.NoteData[i];
				}
			}
			return data;
		},
		/**
		 * 创建表头
		 */
		createTableHead:function(This,columns){
			var tableHeadArray = new Array();
			tableHeadArray.push('<tr>');
			for(var i in columns)
			{
				tableHeadArray.push('<th>'+columns[i].text+'</th>');
			}
			tableHeadArray.push('</tr>');
			
			$(This).append($(tableHeadArray.join('')));
		},
		/**
		 * 创建表数据
		 */
		createTableBody:function(){
			
		},
		//节点数据
		NoteData:[],
		defaults:{
			data:[],//数据源
			columns:[],//列数据
			id:'id',//id列名称
			pidname:'pid',//pid列名称
			pid:0,	//起始PID
			selected:true,//是否可以选中行
			isSetClass:true, //是否设置class
			className:'table table-hover table-bordered table-condensed tree'	//设置的class
		},
		/**
		*加载节点
		*/
		LoadData:function(options)
		{
			var This = this;
			
			/*var defaults={
				data:[],//数据源
				columns:[],//列数据
				pid:0,	//起始PID
				selected:true,//是否可以选中行
				isSetClass:true, //是否设置class
				className:'table table-hover table-bordered table-condensed tree'	//设置的class
			};*/
			
			options=$.extend({},methods.defaults,options);
			
			methods.defaults = options;
			
			//设置class
			if(options.isSetClass)
			{
				$(This).addClass(options.className);
			}
			
			//根据pid获取数据
			var where = function(data,pid)
			{
				var result = new Array();
				for(var i in data)
				{
					if(data[i][options.pidname]==pid)
					{
						result.push(data[i]);
					}
				}
				return result;
			};
			
			//行classFormat、class名称、行htmlFormat、执行StringFormat的字符串、行HTML
			var trClassHtmlFormater='',className='',trHtmlFormater='',forMatStr='',trStr='';
			
			//生成每行数据的format
			(function(){
				var trHtmlFormatArray = new Array();
				trHtmlFormatArray.push('<tr class="{0}" id="{1}">');
				for(var i=1;i<=options.columns.length;i++)
				{
					trHtmlFormatArray.push('<td>{'+(i+1)+'}</td>');
				}
				trHtmlFormatArray.push('</tr>');
				
				trHtmlFormater = trHtmlFormatArray.join('');
			})();
			
			//根据行数据创建FormatStr---使用列里面的name
			var createFormatStr = function(rowData,columns)
			{
				//列的数量
				var colCount=columns.length;
				var s = new Array();
				s.push('methods.StringFormat('+'\''+trHtmlFormater+'\''+',"'+className+'",'+'"'+rowData.id+'",');
				for(var i in columns)
				{
					if(columns[i].formatter!=null)
					{
						s.push('\''+columns[i].formatter(rowData[columns[i].name],rowData));
					}
					else
					{
						s.push('\''+rowData[columns[i].name]);
					}
					if(i<colCount-1)
					{
						s.push('\''+',');
					}else
					{
						s.push('\'');
					}
				}
				s.push(')');
				return s.join('');
			};
			//创建表数据
			var createTableBody = function(data,htmlArray,pid){
				var whereData = where(data,pid);
				//子节点数量
				var childCount=0;
				for(var i in whereData)
				{
				    trClassHtmlFormater = whereData[i][options.pidname] == options.pid ? "treegrid-{0}" : "treegrid-{0} treegrid-parent-{1}";
					//是否根节点
					if (pid == options.pid)
					{
					    className = methods.StringFormat(trClassHtmlFormater, whereData[i][options.id]);
					}
					else
					{
						//不是
					    className = methods.StringFormat(trClassHtmlFormater, whereData[i][options.id], whereData[i][options.pidname]);
					}
					forMatStr=createFormatStr(whereData[i],options.columns);
					
					trStr = eval(forMatStr);
					
					htmlArray.push(trStr);
					
					childCount = where(data,whereData[i][options.id]).length;
					if(childCount>0)
					{
						createTableBody(data,htmlArray,whereData[i][options.id]);
					}
				}
				return htmlArray.join('');
			};
			
			methods.createTableHead(this,options.columns);
			var noteHtml = createTableBody(options.data,new Array,options.pid);
			
			$(this).append($(noteHtml));
			$(this).treegrid();
			
			methods.NoteData=options.data;
			
			if(options.selected)
			{
				methods.treeGridSelectedInit();
			}
		},
		/**
		 * 加载数据-childrens格式数据
		 * 数据格式：默认每条数据里面必须有：id和pid这两列、可以通过设置属性id:'xxx'、pid='xxx' 这两个来使用其他列代替、
		 * 有子节点的通过childrens属性存放
		 */
		Load:function(setting){
			var id='id',pid='pid',options=null;
			
			//行classFormat、class名称、行htmlFormat、执行StringFormat的字符串、行HTML
			var trClassHtmlFormater='',className='',trHtmlFormater='',forMatStr='',trStr='';
			
			options=$.extend({},methods.defaults,setting);
			
			id=options.id;
			pid=options.pid;
			
			//生成每行数据的format
			(function(){
				var trHtmlFormatArray = new Array();
				trHtmlFormatArray.push('<tr class="{0}" id="{1}">');
				for(var i=1;i<=options.columns.length;i++)
				{
					trHtmlFormatArray.push('<td>{'+(i+1)+'}</td>');
				}
				trHtmlFormatArray.push('</tr>');
				
				trHtmlFormater = trHtmlFormatArray.join('');
			})();
			
			//根据行数据创建FormatStr---使用列里面的name
			var createFormatStr = function(rowData,columns)
			{
				//列的数量
				var colCount=columns.length;
				var s = new Array();
				s.push('methods.StringFormat('+'\''+trHtmlFormater+'\''+',"'+className+'",'+'"'+rowData.id+'",');
				for(var i in columns)
				{
					if(columns[i].formatter!=null)
					{
						s.push('\''+columns[i].formatter(rowData[columns[i].name],rowData));
					}
					else
					{
						s.push('\''+rowData[columns[i].name]);
					}
					if(i<colCount-1)
					{
						s.push('\''+',');
					}else
					{
						s.push('\'');
					}
				}
				s.push(')');
				return s.join('');
			};
			//创建表数据
			var createTableBody = function(data,htmlArray,pid){
				for(var i in data)
				{
					//pid==null 根节点
					trClassHtmlFormater = pid==null ? "treegrid-{0}" : "treegrid-{0} treegrid-parent-{1}";
					
					if(pid==null)
					{
						//获取根节点class
						className = methods.StringFormat(trClassHtmlFormater,data[i][id]);
					}
					else
					{
						className = methods.StringFormat(trClassHtmlFormater,data[i][id],pid);
					}
					
					forMatStr=createFormatStr(data[i],options.columns);
					
					trStr = eval(forMatStr);
					
					htmlArray.push(trStr);
					
					//判断是否有子节点
					if(data[i].hasOwnProperty('childrens'))
					{
						if(data[i].childrens.length>0)
						{
							createTableBody(data[i].childrens,htmlArray,data[i][id]);
						}
					}
				}
				
				return htmlArray.join('');
			};
			
			//创建表头
			methods.createTableHead(this,options.columns);
			
			var noteHtml = createTableBody(options.data,new Array,null);
			
			$(this).append($(noteHtml)).treegrid();
			
			methods.NoteData=options.data;
			
			//设置class
			if(options.isSetClass)
			{
				$(this).addClass(options.className);
			}
			//设置是否可以选中行-默认可以
			if(options.selected)
			{
				methods.treeGridSelectedInit();
			}
		}
    };
    $.fn.treegrid = function(method) {
        if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.initTree.apply(this, arguments);
        } else {
            $.error('Method with name ' + method + ' does not exists for jQuery.treegrid');
        }
    };
    /**
     *  Plugin's default options
     */
    $.fn.treegrid.defaults = {
        initialState: 'expanded',
        saveState: false,
        saveStateMethod: 'cookie',
        saveStateName: 'tree-grid-state',
        expanderTemplate: '<span class="treegrid-expander"></span>',
        indentTemplate: '<span class="treegrid-indent"></span>',
        expanderExpandedClass: 'treegrid-expander-expanded',
        expanderCollapsedClass: 'treegrid-expander-collapsed',
        treeColumn: 0,
        getExpander: function() {
            return $(this).find('.treegrid-expander');
        },
        getNodeId: function() {
            var template = /treegrid-([A-Za-z0-9_-]+)/;
            if (template.test($(this).attr('class'))) {
                return template.exec($(this).attr('class'))[1];
            }
            return null;
        },
        getParentNodeId: function() {
            var template = /treegrid-parent-([A-Za-z0-9_-]+)/;
            if (template.test($(this).attr('class'))) {
                return template.exec($(this).attr('class'))[1];
            }
            return null;
        },
        getNodeById: function(id, treegridContainer) {
            var templateClass = "treegrid-" + id;
            return treegridContainer.find('tr.' + templateClass);
        },
        getChildNodes: function(id, treegridContainer) {
            var templateClass = "treegrid-parent-" + id;
            return treegridContainer.find('tr.' + templateClass);
        },
        getTreeGridContainer: function() {
            return $(this).closest('table');
        },
        getRootNodes: function(treegridContainer) {
            var result = $.grep(treegridContainer.find('tr'), function(element) {
                var classNames = $(element).attr('class');
                var templateClass = /treegrid-([A-Za-z0-9_-]+)/;
                var templateParentClass = /treegrid-parent-([A-Za-z0-9_-]+)/;
                return templateClass.test(classNames) && !templateParentClass.test(classNames);
            });
            return $(result);
        },
        getAllNodes: function(treegridContainer) {
            var result = $.grep(treegridContainer.find('tr'), function(element) {
                var classNames = $(element).attr('class');
                var templateClass = /treegrid-([A-Za-z0-9_-]+)/;
                return templateClass.test(classNames);
            });
            return $(result);
        },
        //Events
        onCollapse: null,
        onExpand: null,
        onChange: null

    };
})(jQuery);
