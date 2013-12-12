$.ajax({
    url: 'webapi/secure-quotes',
    type: 'GET',
    dataType: 'json',
    success: onQuotes,
    error: onError,
    beforeSend: setHeader
});

function setHeader(xhr) {
   xhr.setRequestHeader('Security-Token', 'Good Guy');
}

function onQuotes(data)  {
   $.each( data, function( i, item ) {
     $("#quotes tbody").append("<tr><td>"+item.quoteId+"</td><td>"+item.revision+"</td></tr>")
   });
}

function onError(data) {
   alert('SECURITY FAILURE! '+data.statusText);
}