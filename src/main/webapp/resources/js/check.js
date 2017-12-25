function imgClickHandler(e) {
    var x = e.offsetX == undefined ? e.layerX : e.offsetX;
    var y = e.offsetY == undefined ? e.layerY : e.offsetY;
    var r = $("#mainForm\\:RVal_input").val();
    x = (x - 220) / 160 * r;
    y = (y - 219) / -160 * r;
    document.getElementById("mainForm:XVal_input").value = x;
    document.getElementById("mainForm:X").value = x;
    document.getElementById("mainForm:YVal").value = y;
    document.getElementById("mainForm:addButton").click();
}


function drawPoints() {
    document.getElementById("mainForm:X").value = -10;//костыль
    var canvas = document.getElementById("canvas");
    var context = canvas.getContext("2d");
    var r = $("#mainForm\\:RVal_input").val();
    context.clearRect(0, 0, canvas.width, canvas.height);
    var cou = 0;
    $("#mainForm\\:table").find("tr").each(function () {
        var x;
        var y;
        var isHitted;
        var c = 0;
        cou += 1;
        if (cou > 1) {
            $(this).find("td").each(function () {
                if (c === 0)
                    x = $(this).text();
                if (c === 1)
                    y = $(this).text();
                if (c === 3) {
                    isHitted = $(this).text().trim();
                    if (isHitted !== "") {
                        if (isHitted === '1') {
                            context.fillStyle = "#00ff00";
                        } else {
                            context.fillStyle = "#ff0000";
                        }
                        x = x * 160 / r + 220;
                        y = y * (-160) / r + 219;
                        context.fillRect(x, y, 6, 6);
                    }
                }
                c++;
            });
        }
    });

}

function cheat() {
    if (document.getElementById("mainForm:X").value == -10)
        document.getElementById("mainForm:X").value = document.getElementById("mainForm:XVal_input").value;
}

window.onload = drawPoints;

