	function selectData() {
		$('#output').empty();
		$.getJSON('http://localhost:8080/rest/room', function (data) {
			$(data).each(function (index, item) {
				var output = '';
				output += '<tr>';
				output += '		<td>' + item.id + '</td>';
				output += '		<td>' + item.name + '</td>';
				output += '		<td>' + item.admitted + '</td>';
				output += '		<td>' + item.price + '</td>';
				output += '		<td>' + item.state + '</td>';
				output += '		<td>' + item.info + '</td>';
				output += '</tr>';
				$('#intro-header').append(output);
			});
		});
	}