<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DB Test ( using JSON )</h1>
	<button id="btnEmpDetail">Emp 상세</button>
	<button id="btnEmpList">Emp 목록</button>
	<button id="btnEmpInsert">Emp 등록</button>
	<button id="btnEmpChange">Emp 변경</button>
	<button id="btnEmpDelete">Emp 삭제</button>
	
	<script>
		window.onload = function(){
			document.querySelector("#btnEmpDetail").onclick = async function(){
				
				try{
					let response = await fetch('/mydb/empDetail/1500')
					let data = await response.json();
					console.log(data);
				}catch(error){
					console.log(error);
				}
			}
			
			document.querySelector("#btnEmpList").onclick = async function(){
				
				try{
					let response = await fetch('/mydb/empList')
					let data = await response.json();
					console.log(data);
				}catch(error){
					console.log(error);
				}
			}
			
			document.querySelector("#btnEmpInsert").onclick = async function(){
				var empInsertData={
					employeeId:1600,
					firstName:"뮤",
					lastName:'기르동그',
					email:'you@gil.com',
					hireDate:"2022-10-20"
				}
				
				let urlParams = new URLSearchParams(empInsertData);
				let fetchOptions={
					method:'POST',
					body:urlParams
				}
				
				
				try{
					let response = await fetch('/mydb/empInsert',fetchOptions)
					let data = await response.json();
					console.log(data);
				}catch(error){
					console.log(error);
				}
			}
			
			document.querySelector("#btnEmpDelete").onclick = async function(){
				var empInsertData={
					employeeId:1600,
				}
				
				let urlParams = new URLSearchParams(empInsertData);
				let fetchOptions={
					method:'POST',
					body:urlParams
				}
				
				
				try{
					let response = await fetch('/mydb/empDelete',fetchOptions)
					let data = await response.json();
					console.log(data);
				}catch(error){
					console.log(error);
				}
			}
			
			document.querySelector("#btnEmpChange").onclick = async function(){
				var empInsertData={
					employeeId:1600,
					firstName:"뮤123",
					lastName:'기르동그123',
					email:'you123@gil.com',
					hireDate:"2022-10-22"
				}
				
				let urlParams = new URLSearchParams(empInsertData);
				let fetchOptions={
					method:'POST',
					body:urlParams
				}
				
				
				try{
					let response = await fetch('/mydb/empChange',fetchOptions)
					let data = await response.json();
					console.log(data);
				}catch(error){
					console.log(error);
				}
			}
			
		}
	</script>
</body>
</html>