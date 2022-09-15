var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,5})+$/;
var idOfCurrntUser = 0;

$(document).ready(function () {
    $("#my-tabs li").click(function () {
        var myId = $(this).attr("id");
        $(this).removeClass("inactive").siblings().addClass("inactive");
        $(".test-tabs div").hide();
        $("#" + myId + "-content").fadeIn("1000");
    });
    $('#add_button').click(function () {
        $('#people_form')[0].reset();
        $('.modal-title').text("Add people Details");
        $('#action').val("Add");
        $('#operation').val("Add");
    });

    $(document).on('submit', '#people_form', function (event) {

        event.preventDefault();
        var names = $('#names').val();
        var numbers = $('#numbers').val();
        var emails = $('#emails').val();
        var data_of_brith = $('#data_of_brith').val();
        var password1 = $('#password1').val();
        var password2 = $('#password2').val();
        var gender = $("input:radio[name='gender']:checked").val();
        var user_type = $("input:radio[name='user_type']:checked").val();

        var messageError = "";
        var done = false;

        if (names == null || names == '') {
            messageError += "please enter user name\n";
        } else if (!typeof names === 'string' || !names instanceof String) {
            messageError += "please enter a valid name\n";
        }

        if (numbers == null || numbers == '') {
            messageError += "please enter user namber\n";
        } else if (isNaN(numbers)) {
            messageError += "please enter a valid  number\n";
        }

        if (emails == null || emails == '') {
            messageError += "please enter user email\n";
        }
        if (!emails.match(mailformat)) {
            messageError += "please enter a valid  E-mail\n";
        }

        if (data_of_brith == null || data_of_brith == '') {
            messageError += "please enter user dateeee \n";


        }
        // else  if (! Object.prototype.toString.call(data_of_brith) === '[object Date]' && isNaN(data_of_brith)) {
        //     console.log("is date!");
        //     messageError += "please enter a valid  dateeee \n  ";
        // }
        if (password1 == null || password1 == '') {
            messageError += "please enter user paswword\n";
        } else if (!typeof names === 'string' || !names instanceof String) {
            messageError += "please enter a valid password\n";
        }
        if (password2 == null || password2 == '') {
            messageError += "please re write user password\n";
        } else if (!typeof names === 'string' || !names instanceof String) {
            messageError += "please enter a valid password\n";
        }
        if (password1 !== password2) {
            messageError += " the tow password not mached !! re write them !\n";
        }

        if (gender == null || gender == '') {
            messageError += "please choise user Gender\n";
        }
        if (user_type == null || user_type == '') {
            messageError += "plz choise user type\n";
        }


        if (!messageError == "") {
            alert(messageError + "Please follow the instructions below");
            return false;
        } else {
            $.ajax({
                url: "/insert",
                method: 'POST',
                data: new FormData(this),
                contentType: false,
                processData: false,
                async: false,
                success: function (data) {
                    $('#people_form')[0].reset();
                    $('#userModal').modal('hide');
                    //location.reload();

                }
            });

            console.log("herer");
            alert("hi man");
            //location.reload();
        }


    });


    $(document).on('click', '#tab1', function () {
        $('tbody.user-table').empty();
        $(".overlay").show();
        $.ajax({
            url: "/users/getAll",
            dataType: "json",
            type: 'Get',
            contentType: "application/json",
            success: function (data) {
                //$('#emp').append('<br><br>');
                $(data).each(function (index, item) {
                    $('.user-table').append(
                        '<tr><td>' + item.id +
                        '</td><td>' + item.name +
                        '</td><td>' + item.phonenum +
                        '</td><td>' + item.email +
                        '</td><td>' + item.userDateOfBrith +
                        '</td><td>' + item.gender +
                        '</td><td>' + item.userType +

                        '</td><th> <button class="update-user"> Edit</button>' +
                        '</th><th> <button class="delete-user"> Delete</button>' +
                        '</th></tr>'
                    )
                });
            },
            complete: function () {
                $(".overlay").hide();
            }
        });
    });

    $(document).on('click', '#tab2', function () {
        $('tbody.studnt-table').empty();
        $(".overlay").show();
        $.ajax({
            url: "/student/getAll",
            dataType: "json",
            type: 'Get',
            contentType: "application/json",
            success: function (data) {
                $(data).each(function (index, item) {
                    $('.studnt-table').append(
                        '<tr><td>' + item.student_id +
                        '</td><td>' + item.student_name +
                        '</td><td>' + item.student_address +
                        '</td><td>' + item.student_phone +
                        '</td><td>' + item.email +
                        '</td><td>' + item.student_Date_of_brith +
                        '</td><td>' + item.gender +
                        '</td><td>' + item.student_GPA +
                        '</td><td>' + item.student_major +
                        '</td><th> <button class="update-teacher"> Edit</button>' +
                        '</th><th> <button class="delete-teacher"> Delete</button>' +
                        '</th></tr>'
                    )
                });
            },
            complete: function () {
                $(".overlay").hide();
            }
        });
    });


    $(document).on('click', '#tab3', function () {
        $('tbody.teacher-table').empty();
        $(".overlay").show();
        $.ajax({
            url: "/teacher/getAll",
            dataType: "json",
            type: 'Get',
            contentType: "application/json",
            success: function (data) {
                $(data).each(function (index, item) {
                    $('.teacher-table').append(
                        '<tr><td>' + item.teacher_id +
                        '</td><td>' + item.teacher_name +
                        '</td><td>' + item.teacher_address +
                        '</td><td>' + item.teacher_phone +
                        '</td><td>' + item.email +
                        '</td><td>' + item.married +
                        '</td><td>' + item.gender +
                        '</td><td>' + item.teacher_major +
                        '</td><th> <button class="update-teacher"> Edit</button>' +
                        '</th><th> <button class="delete-teacher"> Delete</button>' +
                        '</th></tr>'
                    )
                });
            },
            complete: function () {
                $(".overlay").hide();
            }
        });
    });

    $(document).on('click', '#tab4', function () {
        $('tbody.course-table').empty();
        $(".overlay").show();
        $.ajax({
            url: "/course/getAll",
            dataType: "json",
            type: 'Get',
            contentType: "application/json",
            success: function (data) {
                $(data).each(function (index, item) {
                    $('.teacher-table').append(
                        '<tr><td>' + item.course_id +
                        '</td><td>' + item.course_name +
                        '</td><td>' + item.course_code +
                        '</td><td>' + item.course_secation +
                        '</td><td>' + item.course_time +
                        '</td><th> <button class="update-teacher"> Edit</button>' +
                        '</th><th> <button class="delete-teacher"> Delete</button>' +
                        '</th></tr>'
                    )
                });
            },
            complete: function () {
                $(".overlay").hide();
            }
        });
    });

    $(document).on('click', '#tab5', function () {
        $('tbody.courseBook-table').empty();
        $(".overlay").show();
        $.ajax({
            url: "/CourseBook/getAll",
            dataType: "json",
            type: 'Get',
            contentType: "application/json",
            success: function (data) {
                $(data).each(function (index, item) {
                    $('.teacher-table').append(
                        '<tr><td>' + item.book_id +
                        '</td><td>' + item.book_name +
                        '</td><td>' + item.edition +
                        '</td><td>' + item.price +
                        '</td><th> <button class="update-teacher"> Edit</button>' +
                        '</th><th> <button class="delete-teacher"> Delete</button>' +
                        '</th></tr>'
                    )
                });
            },
            complete: function () {
                $(".overlay").hide();
            }
        });
    });

    $(document).on('click', '#tab6', function () {
        $('tbody.teacherSalary-table').empty();
        $(".overlay").show();
        $.ajax({
            url: "/teacherSalary/getAll",
            dataType: "json",
            type: 'Get',
            contentType: "application/json",
            success: function (data) {
                $(data).each(function (index, item) {
                    $('.teacher-table').append(
                        '<tr><td>' + item.salary_id +
                        '</td><td>' + item.amount +
                        '</td><td>' + item.raise +
                        '</td><td>' + item.total_salary +
                        '</td><th> <button class="update-teacher"> Edit</button>' +
                        '</th><th> <button class="delete-teacher"> Delete</button>' +
                        '</th></tr>'
                    )
                });
            },
            complete: function () {
                $(".overlay").hide();
            }
        });
    });



    $(document).on('click', '.update', function () {
        var currentRow = $(this).closest("tr");
        $('#new_people_form')[0].reset();
        $('#newUserModal').modal('show');
        $('.modal-title1').text("Edit people Details");
        idOfCurrntUser = currentRow.find("td:eq(0)").text();
        var name = currentRow.find("td:eq(1)").text();//        model.addAttribute("userName", userName);
        var phonenum = currentRow.find("td:eq(2)").text();
        var email = currentRow.find("td:eq(3)").text();
        var userDateOfBrith = currentRow.find("td:eq(4)").text();
        var gender = currentRow.find("td:eq(5)").text();
        var userType = currentRow.find("td:eq(6)").text();

        $('#names1').val(name);
        $('#numbers1').val(phonenum);
        $('#emails1').val(email);
        $('#data_of_brith1').val(userDateOfBrith);
        $('#gender1').val(gender);
        $('#user_type1').val(userType);
        $('#action1').val("update");
        $('#operation1').val("Edit");

    });

    $(document).on('submit', '#new_people_form', function (event) {
        event.preventDefault();
        var names = $('#names1').val();
        var numbers = $('#numbers1').val();
        var emails = $('#emails1').val();
        var data_of_brith = $('#data_of_brith1').val();
        var password1 = $('#password11').val();
        var password2 = $('#password22').val();
        var gender = $("input:radio[name='gender']:checked").val();
        var user_type = $("input:radio[name='user_type']:checked").val();


        var messageError = "";
        var done = false;
        if (names == null || names == '') {
            messageError += "please enter user name\n";
        } else if (!typeof names === 'string' || !names instanceof String) {
            messageError += "please enter a valid name\n";
        }

        if (numbers == null || numbers == '') {
            messageError += "please enter user namber\n";
        } else if (isNaN(numbers)) {
            messageError += "please enter a valid  number\n";
        }

        if (emails == null || emails == '') {
            messageError += "please enter user email\n";
        }
        if (!emails.match(mailformat)) {
            messageError += "please enter a valid  E-mail\n";
        }

        if (data_of_brith == null || data_of_brith == '') {
            messageError += "please enter user dateeee \n";

        }
        // else  if (! Object.prototype.toString.call(data_of_brith) === '[object Date]' && isNaN(data_of_brith)) {
        //     console.log("is date!");
        //     messageError += "please enter a valid  dateeee \n  ";
        // }
        if (password1 == null || password1 == '') {
            messageError += "please enter user paswword\n";
        } else if (!typeof names === 'string' || !names instanceof String) {
            messageError += "please enter a valid password\n";
        }
        if (password2 == null || password2 == '') {
            messageError += "please re write user password\n";
        } else if (!typeof names === 'string' || !names instanceof String) {
            messageError += "please enter a valid password\n";
        }
        if (password1 !== password2) {
            messageError += " the tow password not mached !! re write them !\n";
        }

        if (gender == null || gender == '') {
            messageError += "please choise user Gender\n";
        }
        if (user_type == null || user_type == '') {
            messageError += "plz choise user type\n";
        }


        if (!messageError == "") {
            alert(messageError + "Please follow the instructions below");
            return false;
        } else {
            $.ajax({
                url: "user/update",
                method: 'POST',
                dataType: 'json',
                contentType: "application/json",
                processData: false,

                data: JSON.stringify({
                    "id": idOfCurrntUser,
                    "userType": user_type,
                    "name": names,
                    "email": emails,
                    "phonenum": numbers,
                    "gender": gender,
                    "userDateOfBrith": data_of_brith,
                    "passwordConfirmation": password2
                }),
                success: function (data) {

                    $('#new_people_form')[0].reset();
                    $('#newUserModal').modal('hide');
                    location.reload();

                }
            });
        }

        // location.reload();
        // window.location.reload("http://localhost:9000/index");
    });


    $(document).on('click', '.delete-user', function () {

        var currentRow = $(this).closest("tr");
        var col1 = currentRow.find("td:eq(0)").text();
        //var http = new XMLHttpRequest();
        console.log(col1);
        var obj = {id: col1};
        console.log(obj);
        if (confirm("Are you sure you want to delete this user?")) {
            $.ajax({
                url: "/delete/user",
                method: "DELETE",
                contentType: "application/json",
                processData: false,
                data: col1,
                success: function (data) {
                    //this.url : "/index"
                    location.reload();
                    window.location.reload("http://localhost:9000/index");
                    //http.send();
                    //dataTable.ajax.reload();
                }
            });
        } else {
            return false;
        }
    });

    $(document).on('click', '.delete-student', function () {

        var currentRow = $(this).closest("tr");
        var col1 = currentRow.find("td:eq(0)").text();
        //var http = new XMLHttpRequest();
        console.log(col1);
        var obj = {id: col1};
        console.log(obj);
        if (confirm("Are you sure you want to delete this Student?")) {
            $.ajax({
                url: "/delete/student",
                method: "DELETE",
                contentType: "application/json",
                processData: false,
                data: col1,
                success: function (data) {
                    //this.url : "/index"
                    location.reload();
                    //window.location.reload("http://localhost:9000/index");
                    //http.send();
                    //dataTable.ajax.reload();
                }
            });
        } else {
            return false;
        }
    });

    $(document).on('click', '.delete-teacher', function () {

        var currentRow = $(this).closest("tr");
        var col1 = currentRow.find("td:eq(0)").text();
        //var http = new XMLHttpRequest();
        console.log(col1);
        var obj = {id: col1};
        console.log(obj);
        if (confirm("Are you sure you want to delete this teacher?")) {
            $.ajax({
                url: "/delete/teacher",
                method: "DELETE",
                contentType: "application/json",
                processData: false,
                data: col1,
                success: function (data) {
                    //this.url : "/index"
                    location.reload();
                    //window.location.reload("http://localhost:9000/index");
                    //http.send();
                    //dataTable.ajax.reload();
                }
            });
        } else {
            return false;
        }
    });
    $(document).on('click', '.delete-course', function () {

        var currentRow = $(this).closest("tr");
        var col1 = currentRow.find("td:eq(0)").text();
        //var http = new XMLHttpRequest();
        console.log(col1);
        var obj = {id: col1};
        console.log(obj);
        if (confirm("Are you sure you want to delete this course?")) {
            $.ajax({
                url: "/delete/course",
                method: "DELETE",
                contentType: "application/json",
                processData: false,
                data: col1,
                success: function (data) {
                    //this.url : "/index"
                    location.reload();
                    //window.location.reload("http://localhost:9000/index");
                    //http.send();
                    //dataTable.ajax.reload();
                }
            });
        } else {
            return false;
        }
    });
    $(document).on('click', '.delete-course-book', function () {

        var currentRow = $(this).closest("tr");
        var col1 = currentRow.find("td:eq(0)").text();
        //var http = new XMLHttpRequest();
        console.log(col1);
        var obj = {id: col1};
        console.log(obj);
        if (confirm("Are you sure you want to delete this people?")) {
            $.ajax({
                url: "/delete/courseBook",
                method: "DELETE",
                contentType: "application/json",
                processData: false,
                data: col1,
                success: function (data) {
                    //this.url : "/index"
                    location.reload();
                    //window.location.reload("http://localhost:9000/index");
                    //http.send();
                    //dataTable.ajax.reload();
                }
            });
        } else {
            return false;
        }
    });
    $(document).on('click', '.delete-teacherSalary', function () {

        var currentRow = $(this).closest("tr");
        var col1 = currentRow.find("td:eq(0)").text();
        //var http = new XMLHttpRequest();
        console.log(col1);
        var obj = {id: col1};
        console.log(obj);
        if (confirm("Are you sure you want to delete this people?")) {
            $.ajax({
                url: "/delete/teacherSalary",
                method: "DELETE",
                contentType: "application/json",
                processData: false,
                data: col1,
                success: function (data) {
                    //this.url : "/index"
                    location.reload();
                    //window.location.reload("http://localhost:9000/index");
                    //http.send();
                    //dataTable.ajax.reload();
                }
            });
        } else {
            return false;
        }
    });


});


