<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/header.jsp" %>

    <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
        <div class="carousel-inner" style="height: 600px;">
            <div class="carousel-item active">
                <img src="./img/dummy1.jpg" class="d-block w-100" alt="one">
            </div>
            <div class="carousel-item">
                <img src="./img/dummy2.jpg" class="d-block w-100" alt="two">
            </div>
            <div class="carousel-item">
                <img src="./img/dummy3.jpg" class="d-block w-100" alt="three">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <div style="height: 400px;">
        <div></div>
        <div></div>
        <div></div>
    </div>
        
<%@include file="/footer.jsp" %>