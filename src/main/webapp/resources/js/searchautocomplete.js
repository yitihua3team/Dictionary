/**
 * JavaScript file with jQuery Autocomplete feature, calling Controller to get word suggestions.
 */
console.log("entered js");
$(document).ready(function() {
	console.log("entered function");
    $("input#word").autocomplete({
    	minLength: 3,
    	
        source: function(request, response) {
            $.ajax({
            	
                url: "wordSuggestions",
                type: "POST",
                data: { term: request.term },
                dataType: "json",

                success: function(data) {
                    response(data);
                },
                    
                error: function (request, status, error) {
                    console.log(request.responseText);
                }

           });              
        }   
    });
})