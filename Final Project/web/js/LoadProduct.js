/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


new Vue({
    el: '#app',
    data: {
        search: '',
        postList: []
    },
    mounted: function () {
        axios.get('/FinalProject/LoadProduct')
                .then(response => {
                    this.postList = response.data;
                    console.log(response.data);
                })
                .catch(error => {
                    console.log(error);
                });
    },
    computed: {
        filteredList() {
            return this.postList.filter(post => {
                return post.title.toLowerCase().includes(this.search.toLowerCase());
            });
        }
    }
});

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
  document.getElementById('result').value= result;
}