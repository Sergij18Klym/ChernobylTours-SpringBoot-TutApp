<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Participant List</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

    <STYLE>
        *, *:after, *:before {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
            transition: .5s ease-in-out;
        }
        ul { list-style: none; }
        a { text-decoration: none;  outline: none;  color: rgb(247,247,247); }
        img { display: block;  width: 100%; }
        h1, h2, h3, h4, h5, h6 { font-weight: normal;  letter-spacing: 1px;  font-variant: small-caps; }
        body {
            font-family: 'Open Sans', arial, sans-serif;  font-size: 14px;
            line-height: 1;
            color: rgb(247,247,247);
            background: url(https://mir-cdn.behance.net/v1/rendition/project_modules/max_1200/115da797884953.5ecfd8829785a.png);
        }
        header:after, .container:after, footer:after {
            content: "";
            display: table;
            clear: both;
        }
        .container {
            margin: 0 auto;
            width: 100%;
            max-width: 960px;
            padding: 0 15px;
        }
        .container-post { background: rgb(80,80,80);  max-width: 960px;  margin: 0 auto;  padding-top: 30px;  min-width: 506px; }
        /*************************************************************/
        /* CONTENT                                                   */
        /*************************************************************/
        #logo {
            display: block;  float: left;  width: 120px;
            position: absolute;  margin-top: 25px;  margin-left: 150px;
        }

        .forma { margin: 40px; }
        .general-title {
            margin-bottom: 20px;  color: #F8B763;
            text-transform: uppercase;   text-align: center;   font-style: italic;
        }
        .form-content { border: 1px solid #F8B763;  padding: 50px 50px 30px 50px; }
        .form-content > li { margin-bottom: 30px;  padding-bottom: 20px;  text-align: center;  border-bottom: 1px solid rgba(235, 235, 227,.3); }
        .form-content > li:last-child { text-align: left;  border: none; }

        .form-input::placeholder { color: #F8B763; }
        .form-input:focus { border-bottom: 3px solid #F8B763;  background-color: rgba(126, 126, 126,.3); }
        .form-input {
            color: white;  font-style: italic;  font-size: 1.1em;
            width: 400px;  height: 40px;
            outline: none;  border: none;  background: transparent;
            border-bottom: 1px solid #F8B763;
        }
        textarea {
            color: white;  font-style: italic;  font-size: 1.1em;
            width: 100%;  height: 40px;
            outline: none;  border: none;  background: transparent;
            border-bottom: 1px solid #F8B763;
            padding-top: 10px;
        }
        textarea::placeholder { color: #F8B763; }
        textarea:focus { border-bottom: 3px solid #F8B763;  background-color: rgba(126, 126, 126,.3); }
        option { background: rgb(126, 126, 126);  color: white;}
        .button-field { text-align: center;  margin-top: 40px; }
        #submit {
            background: transparent;    color: white;
            outline: none;
            padding: 15px 30px;  margin-right: 120px;
            border: 1px solid;
            border-image: linear-gradient(180deg, #ff3000, #ed0200, #ff096c, #d50082);
            border-image-slice: 1;
            text-transform: uppercase;
            overflow: hidden;
            letter-spacing: 2px;
            cursor: pointer;
        }
        #submit:hover { background-image: linear-gradient(180deg, #ff3000, #ed0200, #ff096c, #d50082);}
        #cancel {
            background: transparent;    color: white;
            outline: none;
            padding: 15px 30px;
            border: 1px solid;
            border-image: linear-gradient(180deg, #ff3000, #ed0200, #ff096c, #d50082);
            border-image-slice: 1;
            overflow: hidden;
            letter-spacing: 1px;
            cursor: pointer;
        }
        #cancel:hover { color: #EF5A42; }

        .button-5 {
            text-decoration: none;  display: inline-block;
            position: relative;  padding: 15px 30px;
            color: rgb(247,247,247);  border: 1px solid #3A374C;
            font-size: 14px;  font-weight: 700;
            white-space: nowrap;
            transition: .3s linear;
        }
        .button-5:before, .button-5:after, .link-content:before, .link-content:after {
            content: "";  position: absolute;
            z-index: 1;
            width: 15px;  height: 15px;
            transition: .3s linear;
        }
        .button-5:before {
            left: -1px;  top: -1px;
            border-left: 1px solid #F8B763;  border-top: 1px solid #F8B763;
        }
        .button-5:after {
            bottom: -1px;  right: -1px;
            border-bottom: 1px solid #F8B763;  border-right: 1px solid #F8B763;
        }
        .link-content:after {
            right: -1px;  top: -1px;
            border-right: 1px solid #F8B763;  border-top: 1px solid #F8B763;
        }
        .link-content:before {
            left: -1px;  bottom: -1px;
            border-bottom: 1px solid #F8B763;  border-left: 1px solid #F8B763;
        }
        .button-5:hover {
            color: #F8B763;  border-color: #F8B763;
        }

        table { width: 100%; }
        th { padding-bottom: 15px; border-bottom: 1px solid #EBEBE3; }
        td { padding-top: 15px; }
        tr.odd { background: rgba(235,211,215,0.5); }
        tr.norm { background: rgba(255,255,240,0.5); }
        tr.odd:hover { background: rgba(235,211,215,1); }
        #trash { transition: .03s linear; font-size: 16px; }
        #trash:hover { color: red; }
        #edit { transition: .03s linear; font-size: 16px; }
        #edit:hover { color: dodgerblue; }
        #add { transition: .03s linear; font-size: 24px; margin-top: 20px; }
        #add:hover { color: #F8B763; }
        /*************************************************************/
        /* MEDIA QUERIES                                             */
        /*************************************************************/
        @media (max-width: 768px) {
            #submit { margin: 0 20px 20px 0; }
            #cancel { margin: 20px 0 0 0; }
            .forma { margin: 10px; }
            .form-content { padding: 35px 25px 0; }
        }
        @media (max-width: 480px) {
            #submit, #cancel { margin: 20px 0; }
        }
    </STYLE>

</head>
<body>

<a id="logo" href="/">
    <img src="https://mir-s3-cdn-cf.behance.net/project_modules/disp/005d2997884953.5ecfb94ab0180.png"
         onmouseover="this.src='https://mir-s3-cdn-cf.behance.net/project_modules/disp/b8280397884953.5ecfb94ab07c7.png'"
         onmouseout="this.src='https://mir-s3-cdn-cf.behance.net/project_modules/disp/005d2997884953.5ecfb94ab0180.png'"
         title="Radioaktivität | Main Site">
</a>

<div class="container-post">
    <div class="container">
        <div class="forma">
            <div class="general-title">Tour List</div>
            <ul class="form-content">

                    <table>
                        <tr>
                            <th>idTour</th>
                            <th>TourTyp</th>
                            <th>StartDate</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <#list modelList as item>
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.tourTyp}</td>
                                <td>${item.startDate}</td>
                                <td style="padding: 15px 5px 0;">
                                    <a href="http://localhost:8085/tours/delete/${item.id}">
                                        <span id="trash" class="fa fa-trash"></span>
                                    </a>
                                </td>
                                <td style="padding: 15px 5px 0;">
                                    <a href="http://localhost:8085/tours/edit/${item.id}">
                                        <span id="edit" class="fa fa-pencil"></span>
                                    </a>
                                </td>
                            </tr>
                        </#list>
                    </table>
                <br>
                <a href="http://localhost:8085/create-tour">
                    <span id="add" class="fa fa-plus"></span>
                </a>

                <div class="button-field">
                    <a href="http://localhost:8085/reloadDB" class="button-5">
                        <span class="link-content">Reload DataBase</span>
                    </a>
                </div>

            </ul>

        </div>
    </div>
</div>

<script>
    (function ($) {
        $(document).on("click", ".nav-toggle", function () {
            $(".nav-toggle").toggleClass("close");
            $("#nav-menu").toggleClass("show");
        });
    })(jQuery);
</script>

</body>
</html>