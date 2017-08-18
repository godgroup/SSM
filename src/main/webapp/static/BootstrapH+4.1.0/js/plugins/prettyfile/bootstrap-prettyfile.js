/*
 * jQuery and Bootsrap3 Plugin prettyFile
 *
 * version 2.0, Jan 20th, 2014
 * by episage, sujin2f
 * Git repository : https://github.com/episage/bootstrap-3-pretty-file-upload
 * 
 * 2016-12-19 修改：make_form函数增加表单验证的内容：required：true表单验证、id:名称和name:名称
 */
( function( $ ) {
	$.fn.extend({
		prettyFile: function( options ) {
			var defaults = {
				text : "选择文件",
				id:'prettyFile',
				name:'prettyFile'
			};

			var options =  $.extend(defaults, options);
			var plugin = this;

			function make_form( $el, _option ) {
				$el.wrap('<div></div>');

				$el.hide();
				
				var textHtml='';
				//添加表单验证
				if(_option.required)
				{
					textHtml='<input id="'+_option.id+'" name="'+_option.name+'" required class="input-large form-control" type="text">';
				}
				else
				{
					textHtml='<input class="input-large form-control" type="text">';
				}
				
				$el.after( '\
					<div class="input-append input-group" style="text-align:left;">\
						<span class="input-group-btn">\
							<button class="btn btn-white" type="button">' + _option.text + '</button>\
						</span>\
						'+textHtml+'\
					</div>\
				' );
				return $el.parent();
			};

			function bind_change( $wrap, multiple ) {
				$wrap.find( 'input[type="file"]' ).change(function () {
					// When original file input changes, get its value, show it in the fake input
					var files = $( this )[0].files,
					info = '';

					if ( files.length == 0 )
						return false;

					if ( !multiple || files.length == 1 ) {
						var path = $( this ).val().split('\\');
						info = path[path.length - 1];
					} else if ( files.length > 1 ) {
						// Display number of selected files instead of filenames
						info = "已选择了" + files.length + ' 个文件';
					}

					$wrap.find('.input-append input').val( info );
				});
			};

			function bind_button( $wrap, multiple ) {
				$wrap.find( '.input-append' ).click( function( e ) {
					e.preventDefault();
					$wrap.find( 'input[type="file"]' ).click();
				});
			};

			return plugin.each( function() {
				$this = $( this );

				if ( $this ) {
					var multiple = $this.attr( 'multiple' );

					$wrap = make_form( $this, options );
					bind_change( $wrap, multiple );
					bind_button( $wrap );
				}
			});
		}
	});
}( jQuery ));

