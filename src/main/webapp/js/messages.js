var msgMap = new Map();
msgMap.set(1401, "Wrong login or password");
msgMap.set(1402, "This email has been already used");
msgMap.set(1403, "Balance less than bill");
msgMap.set(1404, "Inapropriate address format");
msgMap.set(1405, "Inaproppriate value: credit must be greater than 0 and less than 1000");
msgMap.set(1406, "Wrong operation: banned users not allowed to make orders");
msgMap.set(1201, "You successfully registered!");
msgMap.set(1202,"Your order is accepted! Thank you for buying!");

function outputMessage(message) {
    if (message) {
    	document.getElementById("output").innerHTML = msgMap.get(message); 
    }
}