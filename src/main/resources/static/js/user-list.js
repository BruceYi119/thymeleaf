'use strict';

let ap = null;

const main = () => {
	const date = $('input[name=date]').val();
	ap = $('#data-table').DataTable({
		info: false,
        processing: true,
        serverSide: false,
        ajax: `/admin/user/ajax/list`,
		pagingType: 'full_numbers',
		dom: `<".d-flex justify-content-between"lf>t<".d-flex justify-content-center"p>`,
		columns: [
            { data: 'mno' },
            { data: 'id' },
            { data: 'name' },
            { data: 'reg_dt' }
        ],
		columnDefs: [{
			render: function(data, type, row) {
				return convertNumberStr(data);
			},
			targets: 0
		},{
			render: function(data, type, row) {
				switch(data) {
					case 'admin': return '관리자';
					default: return '유저';
				};
			},
			targets: 1
		},{
			render: function(data, type, row) {
				return convertDateStr(data);
			},
			targets: 3
		}]
	});
};

main();