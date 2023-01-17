$(()=>{
    splitedURL=document.URL.split("/");
    const [socID]=splitedURL.reverse();

    //getting societe infos
    let societeInfo;
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/Societe/getSociete/"+socID,
        dataType: "json",
        success:  (response)=> {
            societeInfo=response
            //setting user informations to inputs
            $("#email").val(societeInfo["email"]);
            $("#adresse").val(societeInfo["adresse"]);
            $("#nom").val(societeInfo["nom"]);
            $("#emailLog").val(societeInfo["email"]);
        },
        async:false
    });


     //update information
     $("#updateInfo").on("click",  ()=> {
        //check if all field are'nt empty
        if($("#adresse").val()!='' && $("#nom").val()!=''){
            $.ajax({
                type: "PUT",
                url: "http://localhost:8080/Societe/updateSociete/"+socID,
                data: JSON.stringify({
                        "nom":$("#nom").val(),
                        "adresse":$("#adresse").val(),
                        "email":$("#email").val()
                        }
                ),
                contentType:"application/json",
                dataType: "json",
                error: (jqXHR)=> {
                    // console.log(jqXHR.status)
                        Toastify({
                            text: "information updated!!",
                            className: "success",
                            close:true,
                            style: {
                            background: "green",
                            }
                        }).showToast();
                    
                }
                ,
                async:false
            });
    }else{
        Toastify({
            text: "fields can't be empty!!",
            className: "error",
            close:true,
            style: {
              background: "linear-gradient(red, darkred)",
            }
          }).showToast();
    }
    });

    //update password
    $("#updatePassword").on("click",  () =>{
        if($("#password").val()!=''){
        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/Login/updateLogin/"+$("#emailLog").val(),
            data: JSON.stringify({
                "email":$("#emailLog").val(),
                "password":$("#password").val(),
                "role":"societe"
            }),
            dataType: "json",
            contentType:"application/json",
            error:  (jqXHR) =>{
                Toastify({
                    text: "mot de pass a ete modifer!!",
                    className: "success",
                    close:true,
                    style: {
                      background: "green",
                    }
                  }).showToast();
            },
            async:false
        });
    }else{
        Toastify({
            text: "password can't be empty!!",
            className: "eroor",
            close:true,
            style: {
              background: "linear-gradient(red, darkred)",
            }
          }).showToast();
    }
    });
    $("#offresLink").attr("href", "/offres/"+socID);
    $("#profileLink").attr("href", "/societeProfile/"+socID);
    
})