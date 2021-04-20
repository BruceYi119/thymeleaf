'use strict';

const main = () => {
	$('#data-table').DataTable({
//		order: [[ 4, 'desc' ]],
		info: false,
		dom: `<".d-flex justify-content-between"lf>t<".d-flex justify-content-center"p>`,
		pagingType: 'full_numbers',
//		initComplete: function() {
//			this.api().columns().every(function() {
//				const column = this;
//				let select = $('<select><option value=""></option></select>').appendTo($(column.footer()).empty()).on('change', function() {
//					const val = $.fn.dataTable.util.escapeRegex(
//						$(this).val()
//					);
//
//					column.search(val ? '^' + val + '$' : '', true, false).draw();
//				});
//
//				column.data().unique().sort().each(function(d, j) {
//					select.append('<option value="' + d + '">' + d + '</option>')
//				});
//			});
//		}
//		columnDefs: [
//			{
//				targets: [2],
//				visible: true,
//				searchable: false
//			},
//			{
//				targets: [3],
//				visible: false
//			}
//		]
	});
};

main();