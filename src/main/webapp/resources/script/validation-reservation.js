$(document).ready(() => {
	let isValid = false;
	let isConfirm = false;
	
    console.log('isValid : '+isValid);
    console.log('isConfirm : '+isConfirm);
	
	$('#reservation-confirmed').on('click', e => { 
		e.preventDefault();
	    console.log('e.target : '+e.target);
		
		const startDate = $('#startDate').val();
		const endDate = $('#endDate').val();
		
		const carCode = $('#carCode').val();
		
	    console.log(startDate);
	    console.log(endDate);
		
		if(startDate === "" || endDate === "") {
			alert("대여 기간을 설정해주세요.");
			isValid = false;
			isConfirm = false;
		} else {
			isValid = true;
			isConfirm = true;
		}
		
		if(isValid) {
			console.log('ajax');
			$.ajax({
				"method": "POST",
				"url": `/search/Reservation?carCode=${carCode}&startDate=${startDate}&endDate=${endDate}`
			}).done(response => {
				if(response.isValid) {
					alert("대여 할 수 없는 기간입니다.");
					isConfirm = false;
					isValid = false;
				} else {
					isValid = true;
					alert("대여 기간이 확정되었습니다.");
				}
			})
		}
	
	});
});