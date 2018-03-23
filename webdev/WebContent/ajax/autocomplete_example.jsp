<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Autocomplete - Default functionality</title>
  <link rel="stylesheet" href="../jquery-ui/jquery-ui.css">
  <link rel="stylesheet" href="../jquery-ui/jquery-ui.theme.css">
  <script src="../js/jquery-3.3.1.js"></script>
  <script src="../jquery-ui/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#tags" ).autocomplete({
      source: "autocomplete_action.jsp",
      minLength: 2,
      select: function(event, ui) {
    	  //alert(ui.item.id + ' 키워드가 선택되었습니다.');
      }
    });
  } );
  </script>
</head>
<body>
 
<div class="ui-widget">
  <label for="tags">Tags: </label>
  <input id="tags">
</div>
 
 
</body>
</html>