<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#h2{
  text-align:center;
}
.padding_menu{
	width: 270px;
	float: left;
}
#infotable{
	margin-top: 100px;
}
.padding_rightmenu{
width: 1000px;

float: left;

}
#image {
   width: 180px;
   height: 180px;
}

#nofut{
margin-top:180px;
margin-left: 160px;

}
#backimage {
   position: absolute;
   left: -1px;
   top: 114px;
   z-index: -2;
   width: 1280px;
   overflow: hidden;
}

#back {
   background-color: white;
   left: 90px;
   top: 210px;
   z-index: -1;
   width: 1100px;
   height:400px;
   y-overflow: scroll;
   overflow: visible;
}
div.lefnav {
   border:none;
   padding:1px 1px 0 1px;
   margin-left:30px;
   width:150px;
   
}
div.lefnav a {
   display:block;
   height:25px;
   font:17px/25px;
   background:white;
   color: red;
   text-decoration:none;
   padding-left:10px;
   border-bottom:solid 1px #FAECC5;
}
div.lefnav a:hover,div.lefnav a.active {
   background:#F2CB61;
   
   color:black;
}
.menu{
   padding-top:5px;
   padding-bottom:5px;
}
#home{
	margin-left: 950px;
	margin-top:15px;
	height: 30px;
	width: 150px;
}
#memo{
margin-top:50px;
	width: 750px;
	
}
#team{

width: 80%;
	
}
</style>
</head>
<body>
<div>
<jsp:include page="header.jsp"/>
</div>
<br>
<div style="text-align:center">
      <img width="300px" height="230px" src="img/logo1.jpg">
       <img width="350px" height="200px" src="img/introduction.png"> <br>
       <br>
    	<!-- <br/> -->
    	<img src ="img/intro1.jpg">
    	<br>
    	<img src ="img/intro2.jpg">
    	<br>
    	<br>
    <h3 width="100%"><font size="6px;"><font size="6px;" color="e50101;">PC Manage Helper System</font>은 고장 PC 및 정상적인 PC의 통합관리 및 고장신고의 불편함을 해소하도록 설계되어 있습니다.<br> 학생 여러분의 적극적인 이용에 부응하고자, 더 나은 서비스를 제공할 수 있도록 최선을 다하겠습니다. 감사합니다.</font></h3>
<div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>