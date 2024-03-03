<%-- 
    Document   : students
    Created on : Apr 12, 2023, 4:03:55 PM
    Author     : tritranmn2
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CoursesManager</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <style>
            tr:hover {
                background-color: #ccc;
                cursor: pointer;
            }
        </style>
    </head>
    <body >
        <div class="app row">
            <div class="col-2"></div>
            <div class="main col-8">
                <h2 class="my-3">Web Quản lý học sinh</h2>

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active">
                                <a class="nav-link" href="/CoursesManagerWeb/students">Students <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/CoursesManagerWeb/courses">Courses</a>
                            </li>

                        </ul>
                    </div>
                </nav>
                <div class="form-infor my-3">
                    <h3>Thông tin môn học</h3>
                    <form method="POST" action="/CoursesManagerWeb/courses">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label >Mã môn học</label>
                                <input name="id" type="text" value="${course.getId()}" class="form-control" placeholder="Mã môn">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Tên môn học</label>
                                <input name="name" type="text" value="${course.getName()}" class="form-control" placeholder="Tên môn học">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label >Bài học</label>
                                <input name="lecture" type="text" value="${course.getLecture()}" class="form-control" placeholder="Bài học">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Năm</label>
                                <input name="year" type="text" value="${course.getYear()}" class="form-control" placeholder="Năm">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Ghi chú</label>
                                <input name="note" type="text" value="${course.getNote()}" class="form-control" placeholder="Ghi chú">
                            </div>
                        </div>
                        <div class="btns text-center" >
                            <button type="submit" class="btn btn-primary">Thêm</button>
                            <button type="submit" class="btn btn-success" formaction="/CoursesManagerWeb/courses?isDelete=true">Xoá</button>
                            <button type="submit" class="btn btn-warning" formaction="/CoursesManagerWeb/courses?isUpdate=true">Sửa</button>
                        </div>
                    </form>
                </div>
                <div class="list-courses mt-2">
                    <h3>Danh sách môn học</h3>
                    <form method="GET" action="/CoursesManagerWeb/courses" class="btns d-flex align-items-center my-2" >
                        <select id="nameSort" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                            <option selected>Tên</option>
                            <option value="1">Tăng dần</option>
                            <option value="2">Giảm dần</option>
                        </select>
                        <input name="searchName" type="text" class="form-control col-md-6" placeholder="Tìm theo tên">
                        <button type="submit" class="btn btn-warning">Tìm</button>
                    </form>
                    <table class="table overflow-auto">
                        <thead>
                            <tr>
                                <th scope="col">Mã môn</th>
                                <th scope="col">Tên môn</th>
                                <th scope="col">Bài học</th>
                                <th scope="col">Năm</th>
                                <th scope="col">Ghi chú</th>
                                <th scope="col">Chi tiết</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${courses}" var="course" >
                                <tr data-id="${course.getId()}" data-year="${course.getYear()}" class="item" >
                                    <th scope="row">${course.getId()}</th>
                                    <td>${course.getName()} </td>
                                    <td>${course.getLecture()}</td>
                                    <td>${course.getYear()}</td>
                                    <td>${course.getNote()}</td>
                                    <td ><i class="fa-solid fa-circle-info infor"  "></i></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
              
            </div>

            <div class="col-2"></div>

        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>

            document.getElementById("nameSort").addEventListener("change", function () {
                let value = document.getElementById("nameSort").value;
                window.location.href = "/CoursesManagerWeb/courses?nameSort=" + value;
            });
            const elements = document.querySelectorAll('.item');
            elements.forEach((element) => {
                element.onclick = function (e) {
                    let idCourse = e.currentTarget.getAttribute('data-id');
                    let year = e.currentTarget.getAttribute('data-year');
                    if (e.target.classList.contains('infor')) {
                        window.location.href = `/CoursesManagerWeb/register?idCourse=`+idCourse+'&year='+year;
                    }else{
                        window.location.href = `/CoursesManagerWeb/courses?idChoose=`+idCourse;
                    }
                };
            });
        </script>
    </body>
</html>
