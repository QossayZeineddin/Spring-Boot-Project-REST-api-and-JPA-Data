<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

<head>

    <title>Show data</title>

    <link rel="stylesheet" type="text/css" href="/CSS/css2.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/JS/js.js"></script>

</head>

<body style="background-color: floralwhite ;margin-left: -30%;">
    <article class="test-tabs">
        <ul id="my-tabs">
            <li id="tab1"> Users</li>
            <li id="tab2" class="inactive">Students</li>
            <li id="tab3" class="inactive">Teachers</li>
            <li id="tab4" class="inactive">Courses</li>
            <li id="tab5" class="inactive">Courses Book</li>
            <li id="tab6" class="inactive">Teachers Salary</li>

        </ul>


        <div class="content" id="tab1-content">
            <h1 class="error">Welcome : ${userName} </h1>
            <h2 style="font-style:  oblique; margin-bottom: 10px">Users here</h2>
            <table id="people_table" class="table table-striped">
                <thead bgcolor="#6cd8dc">
                <tr class="table-primary">
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone number</th>
                    <th>E-mail</th>
                    <th>Date of brith</th>
                    <th>Gender</th>
                    <th>Type</th>
                    <th scope="col" width="5%">Edit</th>
                    <th scope="col" width="5%">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${user}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.phonenum}</td>
                    <td>${user.email}</td>
                    <td>${user.userDateOfBrith}</td>
                    <td>${user.gender}</td>
                    <td>${user.userType}</td>
                    <th>
                        <button class="update-user"> Edit</button>
                    </th>
                        <%--            data-toggle="modal" data-target="#userModal1"--%>
                    <th>
                        <button class="delete-user"> Delete</button>
                    </th>
                <tr>
                    </c:forEach>
                </tbody>

            </table>
            </br>
            <span class="tete">
                <a class="btn btn-success btn-lg pind" href="/logout"> Logout</a>
                <button type="button" id="add_button" data-toggle="modal" data-target="#userModal" class="btn btn-success btn-lg pind">Add new
                </button>
            </span>
        </div>

        <div class="content" id="tab2-content">
            <h1 class="error">Welcome : ${userName} </h1>
            <h2 style="font-style:  oblique;">Student here</h2>
            <table id="people_table1" class="table table-striped">
                <thead bgcolor="#6cd8dc">
                <tr class="table-primary">
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone number</th>
                    <th>E-mail</th>
                    <th>Date of brith</th>
                    <th>Gender</th>
                    <th>student_GPA</th>
                    <th>student_major</th>
                    <th scope="col" width="5%">Edit</th>
                    <th scope="col" width="5%">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${student}" var="student">
                <tr>
                    <td>${student.student_id}</td>
                    <td>${student.student_name}</td>
                    <td>${student.student_address}</td>
                    <td>${student.student_phone}</td>
                    <td>${student.email}</td>
                    <td>${student.student_Date_of_brith}</td>
                    <td>${student.gender}</td>
                    <td>${student.student_GPA}</td>
                    <td>${student.student_major}</td>

                    <th>
                        <button class="update-student"> Edit</button>
                    </th>
                    <th>
                        <button class="delete-student"> Delete</button>
                    </th>
                <tr>
                </c:forEach>
                </tbody>

            </table>
            </br>
            <span class="tete">
                <a class="btn btn-success btn-lg pind" href="/logout"> Logout</a>
                <button type="button" id="add_button1" data-toggle="modal" data-target="#userModal" class="btn btn-success btn-lg pind">Add new
                </button>
            </span>
        </div>

        <div class="content" id="tab3-content">
            <h1 class="error">Welcome : ${userName} </h1>
            <h2 style="font-style:  oblique;">Student here</h2>
            <table id="people_table2" class="table table-striped">
                <thead bgcolor="#6cd8dc">
                <tr class="table-primary">
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone number</th>
                    <th>E-mail</th>
                    <th>Is married</th>
                    <th>Gender</th>
                    <th>Teacher Major</th>
                    <th scope="col" width="5%">Edit</th>
                    <th scope="col" width="5%">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teacher}" var="teacher">
                <tr>
                    <td>${teacher.teacher_id}</td>
                    <td>${teacher.teacher_name}</td>
                    <td>${teacher.teacher_address}</td>
                    <td>${teacher.teacher_phone}</td>
                    <td>${teacher.email}</td>
                    <td>${teacher.married}</td>
                    <td>${teacher.gender}</td>
                    <td>${teacher.teacher_major}</td>

                    <th>
                        <button class="update-teacher"> Edit</button>
                    </th>
                    <th>
                        <button class="delete-teacher"> Delete</button>
                    </th>
                <tr>
                    </c:forEach>
                </tbody>

            </table>
            </br>
            <span class="tete">
                <a class="btn btn-success btn-lg pind" href="/logout"> Logout</a>
                <button type="button" id="add_button2" data-toggle="modal" data-target="#userModal" class="btn btn-success btn-lg pind">Add new
                </button>
            </span>
        </div>

        <div class="content" id="tab4-content">
            <h1 class="error">Welcome : ${userName} </h1>
            <h2 style="font-style:  oblique;">Courses here</h2>
            <table id="people_table3" class="table table-striped">
                <thead bgcolor="#6cd8dc">
                <tr class="table-primary">
                    <th>Course Name</th>
                    <th>Coutrse code</th>
                    <th>Course Secation</th>
                    <th>Course Time</th>
                    <th scope="col" width="5%">Edit</th>
                    <th scope="col" width="5%">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${course}" var="course">
                <tr>
                    <td>${course.course_name}</td>
                    <td>${course.course_code}</td>
                    <td>${course.course_secation}</td>
                    <td>${course.course_time}</td>
                    <th>
                        <button class="update-course"> Edit</button>
                    </th>
                    <th>
                        <button class="delete-course"> Delete</button>
                    </th>
                <tr>
                    </c:forEach>
                </tbody>

            </table>
            </br>
            <span class="tete">
                <a class="btn btn-success btn-lg pind" href="/logout"> Logout</a>
                <button type="button" id="add_button3" data-toggle="modal" data-target="#userModal" class="btn btn-success btn-lg pind">Add new
                </button>
            </span>
        </div>

        <div class="content" id="tab5-content">
            <h1 class="error">Welcome : ${userName} </h1>
            <h2 style="font-style:  oblique;">Books here</h2>
            <table id="people_table4" class="table table-striped">
                <thead bgcolor="#6cd8dc">
                <tr class="table-primary">
                    <th>Book ID</th>
                    <th>Book Name</th>
                    <th>Book Edition</th>
                    <th>Book Price </th>

                    <th scope="col" width="5%">Edit</th>
                    <th scope="col" width="5%">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${coursesBook}" var="coursesBook">
                <tr>
                    <td>${coursesBook.book_id}</td>
                    <td>${coursesBook.book_name}</td>
                    <td>${coursesBook.edition}</td>
                    <td>${coursesBook.price}</td>

                    <th>
                        <button class="update-courseBook"> Edit</button>
                    </th>
                    <th>
                        <button class="delete-courseBook"> Delete</button>
                    </th>
                <tr>
                    </c:forEach>
                </tbody>

            </table>
            </br>
            <span class="tete">
                <a class="btn btn-success btn-lg pind" href="/logout"> Logout</a>
                <button type="button" id="add_button4" data-toggle="modal" data-target="#userModal" class="btn btn-success btn-lg pind">Add new
                </button>
            </span>
        </div>

        <div class="content" id="tab6-content">
            <h1 class="error">Welcome : ${userName} </h1>
            <h2 style="font-style:  oblique;">teachers Salary</h2>
            <table id="people_table5" class="table table-striped">
                <thead bgcolor="#6cd8dc">
                <tr class="table-primary">
                    <th>Salary ID</th>
                    <th>Amount</th>
                    <th>Raise </th>
                    <th>Total Salary</th>
                    <th scope="col" width="5%">Edit</th>
                    <th scope="col" width="5%">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teacherSalary}" var="teacherSalary">
                <tr>
                    <td>${teacherSalary.salary_id}</td>
                    <td>${teacherSalary.amount}</td>
                    <td>${teacherSalary.raise}</td>
                    <td>${teacherSalary.total_salary}</td>
                    <th>
                        <button class="update-teacherSalary"> Edit</button>
                    </th>
                    <th>
                        <button class="delete-teacherSalary"> Delete</button>
                    </th>
                <tr>
                    </c:forEach>
                </tbody>

            </table>
            </br>
            <span class="tete">
                <a class="btn btn-success btn-lg pind" href="/logout"> Logout</a>
                <button type="button" id="add_button5" data-toggle="modal" data-target="#userModal" class="btn btn-success btn-lg pind">Add new
                </button>
            </span>
        </div>
    </article>
</body>

</html>


<div id="userModal" class="modal fade">
    <div class="modal-dialog">
        <form method="post" id="people_form" enctype="multipart/form-data">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add new</h4>
                </div>
                <div class="modal-body">
                    <p class="error">${errorMassage}</p>

                    <label>User Name</label>
                    <input type="text" placeholder="write the name plz" name="names" id="names" class="form-control" />
                    <br/>
                    <label>Enter Phone Number </label>
                    <input type="text" placeholder="write the number plz" name="numbers" id="numbers" class="form-control" />
                    <br/>
                    <label>Enter E-mail</label>
                    <input type="text" placeholder="write the Emial plz" name="emails" id="emails" class="form-control" />
                    <br/>
                    <label>Enter Your Date of brith </label>
                    <input type="date" placeholder="write the brithday date < yy-mm-dd > plz" name="data_of_brith" id="data_of_brith" class="form-control" />
                    <br/>
                    <label>Enter Your password </label>
                    <input type="text" placeholder="write the password" name="password1" id="password1" class="form-control" />
                    <br/>
                    <label>re write Your password </label>
                    <input type="text" placeholder=" re write the password" name="password2" id="password2" class="form-control" />
                    <br/>
                    <label>Gender is : </label>
                    <span>
                        <input style="cursor: pointer;" type="radio" name="gender" value="Male" id="g_a"/>
                        <label style="cursor: pointer;" for="g_a">  Male </label>
                    </span>
                    <span>
                        <input style="cursor: pointer;" type="radio" name="gender" value="Female" id="g_b"/>
                        <label style="cursor: pointer;" for="g_b">  Female </label>
                    </span>

                    <br/>
                    <label> User type :</label>
                    <span>
                        <input class="type" style="cursor: pointer;" type="radio" name="user_type" value="1" id="t_1"/>
                        <label style="cursor: pointer;" for="t_1">  admin (1) </label>
                    </span>
                    <span>
                        <input style="cursor: pointer;" type="radio" name="user_type" value="0" id="t_2"/>
                        <label style="cursor: pointer;" for="t_2"> normal (0) </label>
                    </span>
                    <br/>
                    </ul>
                </div>

                <div class="modal-footer">
                    <input type="hidden" name="people_id" id="people_id" />
                    <input type="hidden" name="operation" id="operation" />
                    <input type="submit" name="action" id="action" class="btn btn-primary" value="Add" />
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </div>
        </form>
    </div>
</div>


<div id="newUserModal" class="modal fade">
    <div class="modal-dialog">
        <form method="post" id="new_people_form" enctype="multipart/form-data">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title1">Add new</h4>
                </div>
                <div class="modal-body">
                    <p class="error">${errorMassage}</p>

                    <label>User Name</label>
                    <input type="text" placeholder="write the name plz" name="names" id="names1" class="form-control" />
                    <br/>
                    <label>Enter Phone Number </label>
                    <input type="text" placeholder="write the number plz" name="numbers" id="numbers1" class="form-control" />
                    <br/>
                    <label>Enter E-mail</label>
                    <input type="text" placeholder="write the Emial plz" name="emails" id="emails1" class="form-control" />
                    <br/>
                    <label>Enter Your Date of brith </label>
                    <input type="date" placeholder="write the brithday date < yy-mm-dd > plz" name="data_of_brith" id="data_of_brith1" class="form-control" />
                    <br/>
                    <label>Enter Your password </label>
                    <input type="text" placeholder="write the password" name="password1" id="password11" class="form-control" />
                    <br/>
                    <label>re write Your password </label>
                    <input type="text" placeholder=" re write the password" name="password2" id="password22" class="form-control" />
                    <br/>
                    <label>Gender is : </label>
                    <span>
                        <input style="cursor: pointer;" type="radio" name="gender" value="Male" id="g_a1"/>
                        <label style="cursor: pointer;" for="g_a1">  Male </label>
                    </span>
                    <span>
                        <input style="cursor: pointer;" type="radio" name="gender" value="Female" id="g_b1"/>
                        <label style="cursor: pointer;" for="g_b1">  Female </label>
                    </span>

                    <br/>
                    <label> User type :</label>
                    <span>
                        <input class="type" style="cursor: pointer;" type="radio" name="user_type" value="1" id="t_11"/>
                        <label style="cursor: pointer;" for="t_11">  admin (1) </label>
                    </span>
                    <span>
                        <input style="cursor: pointer;" type="radio" name="user_type" value="0" id="t_21"/>
                        <label style="cursor: pointer;" for="t_21"> normal (0) </label>
                    </span>
                    <br/>
                    </ul>
                </div>

                <div class="modal-footer">
                    <input type="hidden" name="people_id" id="people_id1" />
                    <input type="hidden" name="operation" id="operation1" />
                    <input type="submit" name="action1" id="action1" class="btn btn-primary" value="Update" />
                    <%--                    <button type="button"  id="up" class="btn btn-primary" data-dismiss="modal">Update</button>--%>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </div>
        </form>
    </div>
</div>