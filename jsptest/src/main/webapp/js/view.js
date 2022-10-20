
let html='<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성날짜</th><th>조회수</th></tr>';
getlist();
function getlist(){
	$.ajax({
		url: "/jsptest/list",
		success: function(re){
			console.log(re)
			
			let array=JSON.parse(re);
			console.log(array)
			for(let i=0; i<array.length; i++){
				let board=array[i]
				html+='<tr>'+
				'<td>'+board.bno+'</td>'+
				'<td onclick="getboard('+board.bno+')">'+board.btitle+'</a></td>'+
				'<td>'+board.bwriter+'</td>'+
				'</tr>'
				
			}
			document.querySelector(".list").innerHTML=html
		}
	})
}


function getboard(bno){
	$.ajax({
		url:"/jsptest/view",
		data:{"bno" : bno},
		success: function(re){
			console.log(re)
			
			let s=JSON.parse(re)
			console.log(s)
			let html2='<tr>'+
						'<th>제목</th> <td>'+s.btitle+'</td>'+
					'</tr>'+
					'<tr>'+
						'<th>내용</th> <td>'+s.bcontent+'</td>'+
					'</tr>'	+
					'<tr>'+
						'<th>작성자</th> <td>'+s.bwriter+'</td>'+
					'</tr>'	
			
			
			document.querySelector(".select").innerHTML=html2	
		}
		
	})
}





