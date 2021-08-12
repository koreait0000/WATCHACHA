const chatDiv = document.getElementById('chatDiv');

let stompClient = null;

function connect() {
    const socket = new SockJS('/movie/detail');
    stompClient = Stomp.over(socket);
    // SockJS와 stomp client를 통해 연결을 시도.
    stompClient.connect({}, function (frame) {
        // setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings/'+keyword, function (greeting) {
            showGreeting(JSON.parse(greeting.body).name);
        });
        stompClient.subscribe('/topic/chat/'+keyword, function (chat) {
            showChat(JSON.parse(chat.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function sendName() {
    // /app/hello로 JSON 파라미터를 메세지 body로 전송.
    stompClient.send("/app/hello/"+keyword, {}, JSON.stringify({'name': $("#msgArea").data('username')}));
}

function showGreeting(message) {
    $("#msgArea").append("<tr><td>" + message + "</td></tr>");
}

function sendChat() {
    if($("#msg").val()){
        stompClient.send("/app/chat/"+keyword, {}, JSON.stringify({'name': $("#msgArea").data('username'), 'message': $("#msg").val()}));
        $("#msg").val('');
    }
}
function showChat(chat) {
    $("#msgArea").append("<tr><td>" + chat.name + " : " + chat.message + "</td></tr>");
    $('#msgArea').scrollTop($('#msgArea')[0].scrollHeight);
}

// $(function () {
//     $("form").on('submit', function (e) {
//         e.preventDefault();
//     });
//     $( "#button-send" ).click(function() { sendName(); });
//     $( "#button-send" ).click(function(){ sendChat(); });
// });
$('#button-send').click(function(){ sendChat(); });
document.addEventListener('keyup', e=>{
    if(e.key === 'Enter'){
        if($("#msg").val()){
            sendChat();
        }
    }
})
connect();

// $(document).ready(function (){
//     let keyword = document.querySelector('.prev').dataset.keyword;
//     const username = [$('#msgArea').data('username')];
//     console.log(username);
//     $("#disconn").on("click", (e) => {
//         disconnect();
//     })
//
//     $("#button-send").on("click", (e) => {
//         send();
//     });
//
//     const websocket = new WebSocket("ws://localhost:8090/ws/movie/detail");
//     let stomp = webstomp.over(websocket);
//
//     websocket.onmessage = onMessage;
//     websocket.onopen = onOpen;
//     websocket.onclose = onClose;
//
//     function send(){
//         let msg = document.getElementById("msg");
//
//         console.log(username + ":" + msg.value);
//         websocket.send(username + ":" + msg.value);
//         msg.value = '';
//     }
//
// //채팅창에서 나갔을 때
//     function onClose(evt) {
//         var str = username + ": 님이 방을 나가셨습니다.";
//         websocket.send(str);
//     }
//
// //채팅창에 들어왔을 때
//     function onOpen(evt) {
//         var str = username + ": 님이 입장하셨습니다.";
//         websocket.send(str);
//     }
//
//     function onMessage(msg) {
//         var data = msg.data;
//         var sessionId = null;
//         //데이터를 보낸 사람
//         var message = null;
//         var arr = data.split(":");
//
//         for(var i=0; i<arr.length; i++){
//             console.log('arr[' + i + ']: ' + arr[i]);
//         }
//
//         var cur_session = username;
//
//         //현재 세션에 로그인 한 사람
//         console.log("cur_session : " + cur_session);
//         sessionId = arr[0];
//         message = arr[1];
//
//         console.log("sessionID : " + sessionId);
//         console.log("cur_session : " + cur_session);
//
//         //로그인 한 클라이언트와 타 클라이언트를 분류하기 위함
//         if(sessionId == cur_session){
//             var str = "<div class='col-6'>";
//             str += "<div class='alert alert-secondary'>";
//             str += "<b>" + sessionId + " : " + message + "</b>";
//             str += "</div></div>";
//             $("#msgArea").append(str);
//         }
//         else{
//             var str = "<div class='col-6'>";
//             str += "<div class='alert alert-warning'>";
//             str += "<b>" + sessionId + " : " + message + "</b>";
//             str += "</div></div>";
//             $("#msgArea").append(str);
//         }
//     }
// });