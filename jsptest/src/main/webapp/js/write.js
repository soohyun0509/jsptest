
let writebtn=document.querySelector(".writebtn");

writebtn.addEventListener('click', ()=>{
	let title=document.querySelector(".title").value;
	let content=document.querySelector(".content").value;
	let writer=document.querySelector(".writer").value;
	let password=document.querySelector(".password").value;
	
	
	$.ajax({
	url:"/jsptest/write",
	data:{"title" : title , "content" : content , "writer" : writer, "password" : password},
	success:function(re){
		console.log(re)
		if(re=='true'){
			alert("글 작성 완료됐습니다.")
		}else{alert("글 작성 실패")}
	}
	
	})
})
