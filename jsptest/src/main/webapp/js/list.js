


let html='<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성날짜</th><th>조회수</th></tr>';

getlist()

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
				'<td>'+board.btitle+'</a></td>'+
				'<td>'+board.bwriter+'</td>'+
				'<td>'+board.bdate+'</td>'+
				'<td>'+board.bview+'</td>'+
				'</tr>'
				
			}
			document.querySelector(".list").innerHTML=html
		}
	})
}
