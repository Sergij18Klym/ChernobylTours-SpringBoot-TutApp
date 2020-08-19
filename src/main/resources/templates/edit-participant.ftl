<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.css">
    <title>Update Participant</title>
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

    <script>
        function checkSymbol(kc) {
            if(kc<48 || kc >57)
                return false;
            return true;
        }
    </script>

</head>
<body>

<div class="container-post">
    <div class="container">
        <form class="forma" name="form-main" method="POST">
            <div class="general-title">Client Data Form</div>
            <ul class="form-content">
                <li>
                    <h3 style="text-align: center;"><i>Update your data</i>:</h3>
                    <ul class="field-input">
                        <li>
                            <h2>Name<span class="obl-star"> *</span></h2>
<@spring.formInput path="participantsForm.name" fieldType="text"
attributes="class='form-input' name='Name' required placeholder='Your Name' maxlength='40' "/>
                        </li>
                        <li>
                            <h2>Email<span class="obl-star"> *</span></h2>
<@spring.formInput path="participantsForm.email" fieldType="email"
attributes="class='form-input' name='Email' required placeholder='Your Email' maxlength='30' "/>
                        </li>
                        <li>
                            <h2>Phone Number<span class="obl-star"> *</span></h2>
<@spring.formInput path="participantsForm.phone" fieldType="input"
attributes="class='form-input' name='Phone' required placeholder='Your Phone' maxlength='12' min='6'
onkeypress='return checkSymbol(event.keyCode);' "/>
                        </li>
                        <li>
                            <h2>Your Citizenship<span class="obl-star"> *</span></h2>
                            <select class="form-input" name="citizen" required>
                                <option selected value="ukr">Ukrainian</option>
                                <option value="fremd">Another</option>
                            </select>
                        </li>
                        <li>
                            <h2>Passport Data<span class="obl-star"> *</span></h2>
                            <textarea name="passport" required placeholder="Your passport data" maxlength="120"></textarea>
                        </li>
                    </ul>
                    <div class="button-field">
                        <input type="submit" name="submit" id="submit" value="Update Your Data">
                        <input type="reset" name="cancel" id="cancel" value="Reset Data">
                    </div>
                </li>
            </ul>
        </form>
    </div>
</div>

</body>
</html>