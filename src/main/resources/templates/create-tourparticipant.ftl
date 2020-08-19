<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.css">
    <title>Create TourParticipant</title>
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
        .forma { margin: 40px; }
        .general-title {
            margin-bottom: 20px;  color: #F8B763;
            text-transform: uppercase;   text-align: center;
        }
        .form-content { border: 1px solid #F8B763;  padding: 50px 50px 10px 50px; }
        .form-content > li { margin-bottom: 30px;  padding-bottom: 20px;  text-align: center;  border-bottom: 1px solid rgba(235, 235, 227,.3); }
        .form-content > li:last-child { text-align: left;  border: none; }
        .field-input li { margin-top: 30px;  padding-bottom: 30px; }
        .field-input h2 { padding-bottom: 0.8em; }
        .obl-star { color: #F8B763; }
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

<div class="container-post">
    <div class="container">
        <form class="forma" name="form-main" method="POST">
            <div class="general-title">Tour Participation Form</div>
            <ul class="form-content">
                <li>
                    <h3 style="text-align: center;"><i>Select your tour configuration preferences</i>:</h3>
                    <ul class="field-input">
                        <li>
                            <h2>Participant<span class="obl-star"> *</span></h2>
<@spring.formSingleSelect "tourParticipantsForm.participant", movs,
"class='form-input' name='Participant' required "/>
                        </li>
                        <li>
                            <h2>Tour<span class="obl-star"> *</span></h2>
<@spring.formSingleSelect "tourParticipantsForm.tour", movs2,
"class='form-input' name='Tour' required "/>
                        </li>
                        <li>
                            <h2>Price To Pay<span class="obl-star"> *</span></h2>
<@spring.formInput path="tourParticipantsForm.cost" fieldType="input"
attributes="class='form-input' name='Cost' required maxlength='5' "/>
                        </li>
                    </ul>
                    <div class="button-field">
                        <input type="submit" name="submit" id="submit" value="Submit for a Tour">
                        <input type="reset" name="cancel" id="cancel" value="Reset Data">
                    </div>
                </li>
            </ul>
        </form>
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