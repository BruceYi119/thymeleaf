'use strict';

const setRefresh = () => {
	const time = parseInt($('#refreshTime').val()) * 1000;

	setTimeout(() => { location.reload(); }, time);
};

const main = () => {
	$('#refreshTime').bind('change', function() {
		const time = $(this).val();
		location.href = `?time=${time}`;
	});

	$('#btn-refresh').bind('click', () => {
		location.reload();
	});

	setRefresh();
};

main();