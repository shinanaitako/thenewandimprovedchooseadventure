$(document).ready(
    function() {

    }
);

var monster;
var counter = 0;
var storySoFar = '';

function getMonster() {
    $.ajax({
        method: "GET",
        url: "/monster",
        dataType: "json",
        contentType: "application/json",
        complete: function(response) {
            monster = response.responseJSON;
            populateMonster();
            counter = counter + 1;
        }
    });
}

function youWin() {
    $('#title').html('Safe at last!');
    $('#action').html('<p>You see an opening in the woods, and break out of the thicket to see a town below. You\'ve made it out alive. </p><b>Let\'s take a look at what you went through: </b>' + storySoFar).show();
    $('#buttons').empty();
    $('<button type="button" class="btn btn-success" onclick="startAgain()" data-dismiss="modal">Play again?</button>').appendTo('#buttons');
}

function populateMonster() {
    $('#start_content').empty();
    $('#monster_choice_buttons').empty();
    $('#name').html(monster.name);
    $('#image').attr("src", monster.image);
    $('#description').html(monster.description);
    storySoFar += '<p class="no-margin">' +  monster.description + '</p>';
    for(var i = 0; i < monster.actions.length; i++) {
        $('<button class="btn btn-outline-dark" onclick="populateChoice('+i+')" data-toggle="modal" data-target="#choice_content">'+monster.actions[i].choice+'</button>').appendTo('#monster_choice_buttons');
    }
}

function populateChoice(input) {
    $('#buttons').empty();
    $('#title').html(monster.name);
    if(input == 0) {
        $('#action').html(monster.actions[0].description).show();
        storySoFar += '<p>' + monster.actions[0].description + '</p>';
    } else if (input == 1) {
        $('#action').html(monster.actions[1].description).show();
        storySoFar += '<p>' +  monster.actions[1].description + '</p>';
    } else {
        $('#action').html(monster.actions[2].description).show();
        storySoFar += '<p>' +  monster.actions[2].description + '</p>';
    }
    if(monster.actions[input].result == "CONTINUE") {
        if(counter == 5) {
                $('<button type="button" class="btn btn-success selectionBtn" onclick="youWin()" data-dismiss="modal">Continue</button>').appendTo('#buttons');
        } else {
                $('<button type="button" class="btn btn-success selectionBtn" onclick="getMonster()" data-dismiss="modal">Continue</button>').appendTo('#buttons');
        }
    } else {
        $('#title').html('GAME OVER');
        $('<button type="button" class="btn btn-danger" onclick="startAgain()" data-dismiss="modal">Try again?</button>').appendTo('#buttons');
    }

}

function startAgain() {
    $.ajax({
        method: "GET",
        url: "/restart",
        dataType: "json",
        contentType: "application/json",
        complete: function(response) {
            location.href = "/";
        }
    });
}
