/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//check input
function checkInput() {
    var email = document.SignUpForm.email.value;
    var username = document.SignUpForm.username.value;
    var name = document.SignUpForm.name.value;
    var address = document.SignUpForm.address.value;
    var phoneNumber = document.SignUpForm.phoneNumber.value;
    var firstpassword = document.SignUpForm.password.value;
    var secondpassword = document.SignUpForm.rePassword.value;
    if (email == "" || username == "" || address == "" || phoneNumber == "" || firstpassword == "" || secondpassword == "" || name == "") {
        alert("Please fill all input!");
        return false;
    }
    if (firstpassword == secondpassword) {
        return true;
    } else {
        alert("Password must be same!");
        return false;
    }
}

//search
$(document).ready(function() {

  var jobCount = $('#list .in').length;
  
  $("#search-text").keyup(function () {
     //$(this).addClass('hidden');
  
    var searchTerm = $("#search-text").val();
    var listItem = $('#list').children('div');
  
    
    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
    
      //extends :contains to be case insensitive
  $.extend($.expr[':'], {
  'containsi': function(elem, i, match, array)
  {
    return (elem.textContent || elem.innerText || '').toLowerCase()
    .indexOf((match[3] || "").toLowerCase()) >= 0;
  }
});
    
    $("#list .title").not(":containsi('" + searchSplit + "')").each(function(e)   {
      $(this).parents('div #root_item').addClass('hiding out').removeClass('in');
      setTimeout(function() {
          $('.out').addClass('hidden');
        }, 0);
    });
    
    $("#list .title:containsi('" + searchSplit + "')").each(function(e) {
      $(this).parents('div #root_item').removeClass('hidden out').addClass('in');
      setTimeout(function() {
          $('.in').removeClass('hiding');
        }, 0);
    });
    
  
      var jobCount = $('#list .in').length;
    $('.list-count').text(jobCount + ' items');
    
    //shows empty state text when no jobs found
    if(jobCount == '0') {
      $('#list').addClass('empty');
    }
    else {
      $('#list').removeClass('empty');
    }
    
  });
                    
});

//rate
var result = 0;
var rater = document.getElementById('rate');
var stars = Array.from(rater.children);
rater.addEventListener('touchmove',raterEnd);
stars.forEach(function(item){
  item.addEventListener('mousemove', rateStar.bind(null,item,showResult));
  
});



function raterEnd(e){
  e.preventDefault();
  e.stopPropagation();
  var changedTouch = e.changedTouches[0];
  var elem = document.elementFromPoint(changedTouch.clientX, changedTouch.clientY);
  endElem = elem;
  rateStar(elem,showResult);
}


function rateStar(ratedItem,callback){
   if(stars.includes(ratedItem)){
    result = parseInt(ratedItem.dataset.score);
    stars.forEach(function(item){
       var position =parseInt(item.dataset.score);
      if(position===0){
        item.style.color ="#ccc" ;
      }else if(position<= result){
        item.style.color ="gold";
      }else{
        item.style.color ="#ccc";
      }
    });
   }
  callback();
}
function showResult(){
  document.getElementById('result').value = result;
  document.getElementById('result_DP').innerHTML = "Rank: " + getRank(result);
}

function getRank(result){
    switch (result) {
        case 1:
            return "Bad";
        
        case 2:
            return "Worse";
        
        case 3:
            return "Average";
        
        case 4:
            return "Good";
        
        case 5:
            return "Great";
    }
}