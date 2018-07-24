/**
 * Created by karl on 2018/5/15.
 */
var url = socketUrl;//socket的地址
var ws;//websocket对象
var message = {"id": "", "msg": "", "from": "", "to": ""};
function connect() {
    //根据浏览器类型创建不同的webscoket
    if ('WebSocket' in window) {
        ws = new WebSocket(url);
    } else if ('MozWebSocket' in window) {
        ws = new MozWebSocket(url);
    } else {
        ws = new SockJS(url);
    }
    ws.onopen = function () {
        showMessage("连接成功")
        message.id = $(".identity").val();
        message.msg = "newUser";
        ws.send(JSON.stringify(message));
        message.msg = "";
    };
    ws.onmessage = function (e) {
        console.log("web:onmessage");
        var json = eval('(' + e.data.toString() + ')');
        showMessage(json.from + ":" + json.msg);
    };
    ws.onclose = function () {
        showMessage("close");
    };
    ws.onerror = function (e) {
        showMessage("error");
    };

}

function sendText() {
    message.to = $(".to-user").val();
    message.msg = $(".msg-context").val();
    console.log(message);
    $(".msg-context").val("");
    ws.send(JSON.stringify(message));
    showMessage("我:" + message.msg);
    message.msg = "";
}

function showMessage(msg) {
    $(".show-message").append(msg + "<br/>");
}

