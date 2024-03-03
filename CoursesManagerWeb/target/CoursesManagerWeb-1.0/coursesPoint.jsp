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

                <div class="course-students mt-2">
                    <h3>Danh sách khoá học và điểm số</h3>
                    <form method="POST" action="/CoursesManagerWeb/coursesPoint" class="form-row d-flex align-items-center my-2" >
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label>Mã HS</label>
                                <input  name="idhs" type="text" value="${student.getId()}" class="form-control  mx-1 " placeholder="Mã HS">
                            </div>
                            <div class="form-group col-md-4">
                                <label>Họ tên</label>
                                <input disabled name="nameStudent" type="text" value="${student.getName()}" class="form-control  mx-1" placeholder="Họ tên">
                            </div>
                            <div class="form-group col-md-2">
                                <label>Năm</label>
                                <input name="year" type="text" value="${year}" class="form-control  mx-1" placeholder="Năm">
                            </div>
                            <div class="form-group col-md-2">
                                <label>Tìm kiếm</label>
                                <button type="submit" formaction="/CoursesManagerWeb/coursesPoint?isSearch=true" class="btn btn-primary form-control">Tìm</button>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <input name="idCourse" type="text" value="" class="form-control" placeholder="Mã Môn">
                            </div>
                            <div class="form-group col-md-4">
                                <input name="nameCourse" type="text" value="" class="form-control" placeholder="Tên môn">
                            </div>
                            <div class="form-group col-md-2">
                                <input name="point" type="text" value="" class="form-control" placeholder="Điểm">
                            </div>
                            <div class="form-group col-md-1">
                                <button type="submit" class="btn btn-primary">Thêm</button>
                            </div>
                            <div class="form-group col-md-1">
                                <button type="submit" formaction="/CoursesManagerWeb/coursesPoint?isDelete=true" class="btn btn-success ml-2">Xoá</button>
                            </div>
                        </div>    
                    </form>
                    <div class="row my-2" >
                        <table class="table col-8 overflow-auto">
                            <thead>
                                <tr>
                                    <th scope="col">Mã môn</th>
                                    <th scope="col">Tên môn</th>
                                    <th scope="col">Điểm</th>
                                    <th scope="col">Năm</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${coursesPoints}" var="coursesPoint">
                                    <tr class="item">
                                        <td scope="row">${coursesPoint.getId()}</td>
                                        <td>${coursesPoint.getName()}</td>
                                        <td>${coursesPoint.getPoint()}</td>
                                        <td>${coursesPoint.getYear()}</td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>

                    </div>

                </div>
            </div>

            <div class="col-2"></div>

        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
            const elements = document.querySelectorAll('.item');
            elements.forEach((element) => {
                element.onclick = function () {
                    let idcourse = element.children[0].textContent;
                    let namecourse = element.children[1].textContent;
                    let score = element.children[2].textContent;
                    let year = element.children[3].textContent;
                    document.querySelector('input[name=idCourse]').value = idcourse;
                    document.querySelector('input[name=nameCourse]').value = namecourse;
                    document.querySelector('input[name=point]').value = score;
                    document.querySelector('input[name=year]').value = year;
                };
            });
        </script>
    </body>
</html>
