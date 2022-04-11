/*
 * loader.js用于加载所有js和css
 */
function getRootPath() {
	//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	//获取带"/"的项目名，如：/uimcardprj
	var projectName = "";   //pathName.substring(0, pathName.substr(1).indexOf('/') + 1);    springboot不需要项目名
	return (localhostPaht + projectName);
}
//jquery
document.write('<script src="'+getRootPath()+'/js/jquery.min.js"></script>');
//bootstrap
document.write('<script src="'+getRootPath()+'/js/bootstrap.js"></script>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/bootstrap.css"/>');
document.write('<link rel="stylesheet" href="'+getRootPath()+'/css/bootstrap-theme.css"/>');