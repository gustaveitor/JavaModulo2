//Este javascript esta comentado porque anteriormente lo hacia con el mouse hover y me parecio al pedo
/*
var botonesMenu = document.getElementsByClassName("menudesplegado");
var divs = document.getElementsByClassName("menudiv")
divs[0].addEventListener("mouseover",function(){
		for (var i = botonesMenu.length - 1; i >= 0; i--) {
		botonesMenu[i].style.visibility="visible";
	};
});
divs[0].addEventListener("mouseout",function(){
	for (var i = botonesMenu.length - 1; i >= 0; i--) {
	botonesMenu[i].style.visibility="hidden";
	};
});
*/

//Eventos de click para la apertura del menu

var menuOpciones= document.getElementById("opciones");
var botonesMenu = document.getElementsByClassName("menudesplegado");
var i=0;
menuOpciones.addEventListener("click",function(){
	if (menuOpciones.className.indexOf("clickboton")>0) {
		for (i = botonesMenu.length -1 ; i >= 0; i--) {
			botonesMenu[i].style.visibility="hidden";
		    botonesMenu[i].className= botonesMenu[i].className.replace(" lejania"+i,'');
		}
       menuOpciones.className=menuOpciones.className.replace(" clickboton",'');
	}
	else{
		for (i = botonesMenu.length -1; i >= 0; i--) {
		botonesMenu[i].style.visibility="visible";
		  botonesMenu[i].className=  botonesMenu[i].className+(" lejania"+i);
	}
	menuOpciones.className=menuOpciones.className + " clickboton";
	}
});
var eventoBut = document.getElementsByClassName("eventbut");
var twitterBut = document.getElementsByClassName("tweet");
var contactoBut = document.getElementsByClassName("conmenu");
twitterBut[0].firstChild.addEventListener("mouseover",function(){ appear(document.getElementById('lbltweet'), 0, 5, 20)});
twitterBut[0].firstChild.addEventListener("mouseleave",function(){ appear(document.getElementById('lbltweet'), 100, -5, 20)});

eventoBut[0].firstChild.addEventListener("mouseover",function(){ appear(document.getElementById('lblevent'), 0, 5, 20)});
eventoBut[0].firstChild.addEventListener("mouseleave",function(){ appear(document.getElementById('lblevent'), 100, -5, 20)});

contactoBut[0].firstChild.addEventListener("mouseover",function(){ appear(document.getElementById('lblcontact'), 0, 5, 20)});
contactoBut[0].firstChild.addEventListener("mouseleave",function(){ appear(document.getElementById('lblcontact'), 100, -5, 20)});
//appear(document.getElementsByTagName('DIV')[0], 100, -5, 40);
function appear(elm, c, step, speed){
    var t_o;
    //la opacida
    c = c || 0;
    //incremento de la opacidad
    step = step || 5;
    //el tiempo de espera entre las opacidades
    speed = speed || 50; 

    t_o = setInterval(function(){
        //transformo la opacidad en decimal (porque claramente 0 y 1 son los valores)
        var opacity = c / 100;
        //pecho la siguiente opacidad
        c = c + step; 
        if(opacity > 1 || opacity < 0){
            clearInterval(t_o);
            //1 opac , 0 transp
            return; 
        }
        //modern browsers
        elm.style.opacity = opacity;
        //pal IE, pobre ie
        elm.style.filter = 'alpha(opacity=' + opacity*100 + ')';
    }, speed);
}
var labelBrand  = document.getElementsByClassName("brand");
labelBrand[0].addEventListener("click",function(){
	document.location.href="/Comiqueria/index_App";
	
});
/*

$(document).ready(function(){
    $("button").click(function(){
        var div = $("div");
        div.animate({height: '300px', opacity: '0.4'}, "slow");
        div.animate({width: '300px', opacity: '0.8'}, "slow");
        div.animate({height: '100px', opacity: '0.4'}, "slow");
        div.animate({width: '100px', opacity: '0.8'}, "slow");
    });
});*/