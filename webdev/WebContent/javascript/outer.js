/**
 * 
 */
//window.onload = function() {
//	var elementTd = document.getElementsByTagName('td');
//	for (let i = 0; i < elementTd.length; i++) {
//		var elem = elementTd.item(i);
//		elem.onclick = function() {
//			this.style.display = 'none';
//		}
//	}
//}

$(document).ready(function() {
	//alert("GoGoGo!");
	$('td').click(function() {
		$(this).hide();
	});
});