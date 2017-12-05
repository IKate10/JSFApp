
function imgClickHandler(ClickEvent) {
    var parrentPos = getPosition(ClickEvent.currentTarget);
    var xPos = ClickEvent.clientX - parrentPos.x;
    var yPos = ClickEvent.clientY - parrentPos.y;
    var height = ClickEvent.currentTarget.clientHeight;
    var width = ClickEvent.currentTarget.clientWidth;
    r = document.getElementById('RVal').value;
    var yVal = height / 2 - yPos;
    var xVal = xPos - width / 2;
    yVal = (10 * yVal) / height;
    xVal = (10 * xVal) / width;
    document.getElementById('mainForm:XVal').value = xVal;
    document.getElementById('mainForm:YVal').value = yVal;
    document.getElementById('mainForm:hiddenSubmit').click();
}


function drawPoints() {
    var b_canvas = document.getElementById("canv");
    b_canvas.width = b_canvas.width;
    var b_context = b_canvas.getContext("2d");
    var x;
    var y;
    var r = document.forms["mainForm"]["RVal"].value;
    if (r.length == 0) {
        return;
    } else {
        if (isNaN(r) && r.length != 0) {
            return;
        } else {
            if (r > 5 || r < 2) {
                return;
            }
        }
    }
}

function addPoint() {
    var x = document.forms["mainForm"]["XVal"].value;
    var y = document.forms["mainForm"]["YVal"].value;
    var r = document.forms["mainForm"]["RVal"].value;

}

    function validateForm() {
        var x = document.forms["mainForm"]["XVal"].value;
        var y = document.forms["mainForm"]["YVal"].value;
        var r = document.forms["mainForm"]["RVal"].value;

        var error = '';

        if (y.length == 0) {
            error = error + "Введите Y.\n"
        }

        if (isNaN(y) && y.length != 0) {
            error = error + "Введите число в поле Y.\n";
        }

        if (y < -3.0 || y > 3.0) {
            error = error+"Введите число в заданном промежутке в поле Y.\n";
        }

        if (error!= '') {
            document.getElementById('MyAnchor').textContent = error;
            return false;
        }


        document.getElementById("mainForm").submit();

    }






function resetR() {
    document.getElementById('mainForm:hiddenSubmit2').click();
}


function getPosition(element) {
    var xPos = 0;
    var yPos = 0;
    while (element) {
        xPos += (element.offsetLeft - element.scrollLeft + element.clientLeft);
        yPos += (element.offsetTop - element.scrollTop + element.clientTop);
        element = element.offsetParent;
    }
    return {x: xPos, y: yPos};
}


window.onload = function () {
    document.getElementById('mainForm:XVal').onclick = function () {
        document.getElementById('mainForm:XVal').value = this.value;
    }
    document.getElementById('mainForm:YVal').onkeyup = function () {
        this.value = checkIntervalY(this.value);
    }
    document.getElementById('mainForm:YVal').onchange = function () {
        this.value = checkIntervalY(this.value);
    }
}

