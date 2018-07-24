/**
 * 
 */
//获取url内参数函数
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return decodeURI(r[2]); return null;
}
//页面跳转函数
function goToPage(type){
	if(type == 'park'){
		location.href = "./freeParking.html";
	}else if(type == 'room'){
		location.href = "./myRoom.html";
	}else if(type == 'device'){
		location.href = "./myDevice.html";
	}else if(type == 'QRcode'){
		location.href = "./QRCode.html";
	}
}