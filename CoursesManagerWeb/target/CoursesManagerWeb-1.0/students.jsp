<%-- 
    Document   : students
    Created on : Apr 12, 2023, 4:03:55 PM
    Author     : tritranmn2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
                    <h3>Thông tin học sinh</h3>
                    <form method="POST" action="/CoursesManagerWeb/students">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label >Mã học sinh</label>
                                <input name="id" type="text" value="${student.getId()}" class="form-control" placeholder="Mã số">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Họ và tên</label>
                                <input name="name" type="text" value="${student.getName()}" class="form-control" placeholder="Họ và tên">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label >Ngày sinh</label>
                                <input name="birthday" type="text" value="${student.getBirthday()}" class="form-control" placeholder="Ngày sinh">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Địa chỉ</label>
                                <input name="address" type="text" value="${student.getAddress()}" class="form-control" placeholder="Địa chỉ">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label >Khối</label>
                                <input name="grade" type="text" value="${student.getGrade()}" class="form-control" placeholder="Khối">
                            </div>
                            <div class="form-group col-md-6">
                                <label>Ghi chú</label>
                                <input name="note" type="text" value="${student.getNote()}" class="form-control" placeholder="Ghi chú">
                            </div>
                        </div>
                        <div class="btns text-center" >
                            <button type="submit" class="btn btn-primary">Thêm</button>
                            <button type="submit" class="btn btn-success" formaction="/CoursesManagerWeb/students?isDelete=true">Xoá  </button>
                            <button type="submit" class="btn btn-warning" formaction="/CoursesManagerWeb/students?isUpdate=true">Sửa </button>
                        </div>
                    </form>


                </div>
                <div class="list-student mt-2">
                    <h3>Danh sách học sinh</h3>
                    <form method="GET" action="/CoursesManagerWeb/students" class="btns d-flex align-items-center my-2" >
                        <select id="nameSort" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                            <option selected>Tên</option>
                            <option value="1">Tăng dần</option>
                            <option value="2">Giảm dần</option>
                        </select>
                        <select id="gradeSort" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                            <option selected>Khối</option>
                            <option value="1">Tăng dần</option>
                            <option value="2">Giảm dần</option>
                        </select>
                        <input name="searchName" type="text" class="form-control col-md-6" placeholder="Tìm theo tên">
                        <button type="submit" class="btn btn-warning">Tìm</button>
                    </form>
                    <table class="table overflow-auto">
                        <thead>
                            <tr>
                                <th scope="col">Mã HS</th>
                                <th scope="col">Họ tên</th>
                                <th scope="col">Khối</th>
                                <th scope="col">Ngày sinh</th>
                                <th scope="col">Địa chỉ</th>
                                <th scope="col">Ghi chú</th>
                                <th scope="col">Chi tiết</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${students}" var="student" >
                                <tr data-id="${student.getId()}" class="item" " >
                                    <th scope="row">${student.getId()}</th>
                                    <td>${student.getName()}</td>
                                    <td>${student.getGrade()}</td>
                                    <td>${student.getBirthday()}</td>
                                    <td>${student.getAddress()}</td>
                                    <td>${student.getNote()}</td>
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
                window.location.href = "/CoursesManagerWeb/students?nameSort=" + value;
            });
            document.getElementById("gradeSort").addEventListener("change", function () {
                let value = document.getElementById("gradeSort").value;
                window.location.href = "/CoursesManagerWeb/students?gradeSort=" + value;
            });
            const elements = document.querySelectorAll('.item');
            elements.forEach((element) => {
                element.onclick = function (e) {
                    let idStudent = e.currentTarget.getAttribute('data-id');
                    if (e.target.classList.contains('infor')) {
                        window.location.href = `/CoursesManagerWeb/coursesPoint?idhs=`+idStudent;
                    } else {
                        window.location.href = '/CoursesManagerWeb/students?idChoose='+idStudent;
                    }
                };
            });
        </script>

    </body>
</html>
