'use strict';

const initBoardList = () => {
	$('table.table > tbody > tr').bind('click', function() {
		const bno = $(this).attr('data-bno');

		location.href=`/board/detail/${bno}`;
	});
};

initBoardList();