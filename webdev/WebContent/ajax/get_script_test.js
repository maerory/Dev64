$.getJSON( "test.json", function( data ) {
	  var items = [];
	  $.each( data, function( key, val ) {
	    items.push( "<li id='" + key + "'>" + val + "</li>" );
	  });
	 
	  let vol = $( "<ol/>", {
	    "class": "my-new-list",
	    html: items.join( "" )
	  });
	  
	  $("#output").html(vol);
	});