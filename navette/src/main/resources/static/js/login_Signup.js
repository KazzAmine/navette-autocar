var rolee;
$(()=>{
    //login infos
    let logEmail=$("#Logemail");
    let logPassword=$("#Logpassword");
    //getting login infos to check
    const getLogin=(email,password)=>{
        let res=null
         $.ajax({
        type: "POST",
        url: "http://localhost:8080/Login/getLoginResult/"+email+"/"+password,
        dataType: "json",
        success: function (response) {
            res=response
        },
        async:false
    });
    return res
    }
    //getting user infos by email
    const getUserINfo=(email)=>{
        let res=null
         $.ajax({
        type: "POST",
        url: "http://localhost:8080/Client/getclientbymail/"+email,
        dataType: "json",
        success: function (response) {
            res=response
        },
        async:false
    });
    return res
    }
    //getting societe info
    const getSocieteInfo=(email)=>{
      let res=null
       $.ajax({
      type: "POST",
      url: "http://localhost:8080/Societe/getsocietebymail/"+email,
      dataType: "json",
      success: function (response) {
          res=response
      },
      async:false
  });
  return res
  }
    //calling api to create sessions
    const CreateSeesionGetInfo=(role,cin)=>{
      let stRole;
      $.ajax({
        type: "POST",
        url: "http://localhost:8080/Login/createSess/"+role+"/"+cin,
        dataType: "json",
        success: function (res) {
            stRole=res;
        },
        async:false
    });
    return stRole
    }
   //login button event handler
    $("#btnlogin").on("click",()=>{

        if(logEmail.val()=='' || logPassword.val()==''){
            Toastify({
                text: "il faut remplir tous les champs",
                className: "alert",
                close:true,
                style: {
                  background: "red",
                }
              }).showToast();
        }else{
            
          loggedOrNo= getLogin(logEmail.val(),logPassword.val())
          
           if(loggedOrNo==null){
            Toastify({
                text: "invalide email or mot de pass",
                className: "alert",
                close:true,
                style: {
                  background: "red",
                }
              }).showToast();
           }else if(loggedOrNo["role"]=="client"){
            Toastify({
                text: "CONNECTED SUCCESSFULLY",
                className: "success",
                close:true,
                style: {
                  background: "green",
                }
              }).showToast();
              let userinfo=getUserINfo(loggedOrNo["email"])
              let role =CreateSeesionGetInfo(loggedOrNo["role"],userinfo["cin"])
              console.log(userinfo["cin"])
              if(loggedOrNo["role"]=="client"){
                rolee=loggedOrNo["role"];
                window.location.replace("/clientProfile/"+userinfo["cin"])
                
              }
           }else if(loggedOrNo["role"]=="societe"){
            let societeInfo=getSocieteInfo(loggedOrNo["email"])
            console.log(societeInfo)
            let role =CreateSeesionGetInfo(loggedOrNo["role"],societeInfo["socId"])
           
            if(loggedOrNo["role"]=="societe"){
              rolee=loggedOrNo["role"];
              window.location.replace("/societeProfile/"+societeInfo["socId"])
              
            }
           }
           
        }
    })



    //signin up Client
    $("#signupClient").on("click",()=>{
      //getting form data
      let userData={
        "cin":$("#cin").val(),
        "nom":$("#nom").val(),
        "prenom":$("#prenom").val(),
        "ville":$("#ville").val(),
        "email":$("#email").val()
      };
      let loginData={
        "email":$("#email").val(),
        "password":$("#password").val(),
        "role":"client"
      }
      

      $.ajax({
        type: "POST",
        url: "http://localhost:8080/Client/addclient",
        data: JSON.stringify(userData),
        dataType: "json",
        contentType:"application/json",
        error: function (jqXHR) {
        }
      });

      $.ajax({
        type: "POST",
        url: "http://localhost:8080/Login/addLog",
        data: JSON.stringify(loginData),
        dataType: "json",
        contentType:"application/json",
        error: function (jqXHR) {
          window.location.replace("/login")
        }
      });
    })



    //signup societe
    $("#signupSociete").on("click",()=>{
      //generate id for societe
      let socName=$("#socName").val().slice(0,5)
      
      let Socid=socName.trim()+Math.floor(Math.random() * 500) + 1
      //getting form data
      let societeData={
        "socId":Socid,
        "nom":$("#socName").val(),
        "adresse":$("#adresse").val(),
        "email":$("#socEmail").val()
      };
      let loginData={
        "email":$("#socEmail").val(),
        "password":$("#password").val(),
        "role":"societe"
      }

      $.ajax({
        type: "POST",
        url: "http://localhost:8080/Societe/addsociete/"+Socid,
        data: JSON.stringify(societeData),
        dataType: "json",
        contentType:"application/json",
        error: function (jqXHR) {
        },async:false
      });

      $.ajax({
        type: "POST",
        url: "http://localhost:8080/Login/addLog",
        data: JSON.stringify(loginData),
        dataType: "json",
        contentType:"application/json",
        error: function (jqXHR) {
          window.location.replace("/login");
        }
      });
    })
})