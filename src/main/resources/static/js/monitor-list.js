'use strict';

let dataTable = null;

const main = () => {
	const date = $('input[name=date]').val();
	dataTable = $('#data-table').DataTable({
		info: false,
        processing: true,
        serverSide: false,
		deferRender: true,
        ajax: `/monitor/ajax/list/${date}`,
		pagingType: 'full_numbers',
		dom: `<".d-flex justify-content-between"lf>t<".d-flex justify-content-center"p>`
	});
};

main();