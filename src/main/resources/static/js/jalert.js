(function(n){n.alerts={verticalOffset:-75,horizontalOffset:0,repositionOnResize:!0,overlayOpacity:.5,overlayColor:"#000",draggable:!0,okButton:"&nbsp;OK&nbsp;",cancelButton:"&nbsp;Cancel&nbsp;",dialogClass:null,alert:function(t,i,r){i==null&&(i="Alert");n.alerts._show(i,t,null,"alert",function(n){r&&r(n)})},success:function(t,i,r){i==null&&(i="Success");n.alerts._show(i,t,null,"success",function(n){r&&r(n)})},error:function(t,i,r){i==null&&(i="Error");n.alerts._show(i,t,null,"error",function(n){r&&r(n)})},info:function(t,i,r){i==null&&(i="Info");n.alerts._show(i,t,null,"info",function(n){r&&r(n)})},confirm:function(t,i,r){i==null&&(i="Confirm");n.alerts._show(i,t,null,"confirm",function(n){r&&r(n)})},prompt:function(t,i,r,u){r==null&&(r="Prompt");n.alerts._show(r,t,i,"prompt",function(n){u&&u(n)})},_show:function(t,i,r,u,f){n.alerts._hide();n.alerts._overlay("show");n("BODY").append('<div id="popup_container"><h1 id="popup_title"><\/h1><div id="popup_content"><div id="popup_message"><\/div><\/div><\/div>');n.alerts.dialogClass&&n("#popup_container").addClass(n.alerts.dialogClass);n("#popup_container").css({position:"fixed",zIndex:99999,padding:0,margin:0});n("#popup_title").text(t);n("#popup_title").addClass(u);n("#popup_content").addClass(u);n("#popup_message").text(i);n("#popup_message").html(n("#popup_message").text().replace(/\n/g,"<br />"));n("#popup_container").css({minWidth:n("#popup_container").outerWidth(),maxWidth:n("#popup_container").outerWidth()});n.alerts._reposition();n.alerts._maintainPosition(!0);switch(u){case"alert":n("#popup_message").after('<div id="popup_panel"><button title="'+n.alerts.okButton+'"  id="popup_ok" class="btn yellow">OK<\/button><\/div>');n("#popup_ok").click(function(){n.alerts._hide();f(!0)});n("#popup_ok").focus().keypress(function(t){(t.keyCode==13||t.keyCode==27)&&n("#popup_ok").trigger("click")});break;case"success":n("#popup_message").after('<div id="popup_panel"><button title="'+n.alerts.okButton+'"  id="popup_ok" class="btn yellow">OK<\/button><\/div>');n("#popup_ok").click(function(){n.alerts._hide();f(!0)});n("#popup_ok").focus().keypress(function(t){(t.keyCode==13||t.keyCode==27)&&n("#popup_ok").trigger("click")});break;case"error":n("#popup_message").after('<div id="popup_panel"><button title="'+n.alerts.okButton+'"  id="popup_ok" class="btn yellow">OK<\/button><\/div>');n("#popup_ok").click(function(){n.alerts._hide();f(!0)});n("#popup_ok").focus().keypress(function(t){(t.keyCode==13||t.keyCode==27)&&n("#popup_ok").trigger("click")});break;case"info":n("#popup_message").after('<div id="popup_panel"><button title="'+n.alerts.okButton+'"  id="popup_ok" class="btn yellow">OK<\/button><\/div>');n("#popup_ok").click(function(){n.alerts._hide();f(!0)});n("#popup_ok").focus().keypress(function(t){(t.keyCode==13||t.keyCode==27)&&n("#popup_ok").trigger("click")});break;case"confirm":n("#popup_message").after('<div id="popup_panel"><button title="'+n.alerts.cancelButton+'" id="popup_cancel" class="btn yellow">Cancel<\/button>&nbsp;&nbsp;<button title="'+n.alerts.okButton+'"  id="popup_ok" class="btn yellow">OK<\/button><\/div>');n("#popup_ok").click(function(){n.alerts._hide();f&&f(!0)});n("#popup_cancel").click(function(){n.alerts._hide();f&&f(!1)});n("#popup_ok").focus();n("#popup_ok, #popup_cancel").keypress(function(t){t.keyCode==13&&n("#popup_ok").trigger("click");t.keyCode==27&&n("#popup_cancel").trigger("click")});break;case"prompt":n("#popup_message").append('<br /><input type="text" size="30" id="popup_prompt" />').after('<div id="popup_panel"><input type="button" value="'+n.alerts.okButton+'" id="popup_ok" /> <input type="button" value="'+n.alerts.cancelButton+'" id="popup_cancel" /><\/div>');n("#popup_prompt").width(n("#popup_message").width());n("#popup_ok").click(function(){var t=n("#popup_prompt").val();n.alerts._hide();f&&f(t)});n("#popup_cancel").click(function(){n.alerts._hide();f&&f(null)});n("#popup_prompt, #popup_ok, #popup_cancel").keypress(function(t){t.keyCode==13&&n("#popup_ok").trigger("click");t.keyCode==27&&n("#popup_cancel").trigger("click")});r&&n("#popup_prompt").val(r);n("#popup_prompt").focus().select()}if(n.alerts.draggable)try{n("#popup_container").draggable({handle:n("#popup_title")});n("#popup_title").css({cursor:"move"})}catch(e){}},_hide:function(){n("#popup_container").remove();n.alerts._overlay("hide");n.alerts._maintainPosition(!1)},_overlay:function(t){switch(t){case"show":n.alerts._overlay("hide");n("BODY").append('<div id="popup_overlay"><\/div>');n("#popup_overlay").css({position:"absolute",zIndex:99998,top:"0px",left:"0px",width:"100%",height:n(document).height(),background:n.alerts.overlayColor,opacity:n.alerts.overlayOpacity});break;case"hide":n("#popup_overlay").remove()}},_reposition:function(){var t=n(window).height()/2-n("#popup_container").outerHeight()/2+n.alerts.verticalOffset,i=n(window).width()/2-n("#popup_container").outerWidth()/2+n.alerts.horizontalOffset;t<0&&(t=0);i<0&&(i=0);n("#popup_container").css({top:t+"px",left:i+"px"});n("#popup_overlay").height(n(document).height())},_maintainPosition:function(t){if(n.alerts.repositionOnResize)switch(t){case!0:n(window).bind("resize",n.alerts._reposition);break;case!1:n(window).unbind("resize",n.alerts._reposition)}}};jAlert=function(t,i,r){n.alerts.alert(t,i,r)};jSuccess=function(t,i,r){n.alerts.success(t,i,r)};jError=function(t,i,r){n.alerts.error(t,i,r)};jInfo=function(t,i,r){n.alerts.info(t,i,r)};jConfirm=function(t,i,r){n.alerts.confirm(t,i,r)};jPrompt=function(t,i,r,u){n.alerts.prompt(t,i,r,u)}})(jQuery)