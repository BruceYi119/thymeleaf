'use strict';

const initMod = () => {
	$('#btn-delete').bind('click', function() {
		const bno = $(this).attr('data-bno');

		$.ajax({
			url: '/board',
		    type: "DELETE",
		    data: { bno: bno },
		    success: (res) => {
		        if (res === 'succ') {
		        	alert('삭제 성공!');
		        	location.href='/board/list';
		        } else {
		        	alert('삭제 실패!');		        
		        }
		    }
		});
	});
};

initEdit();
initMod();