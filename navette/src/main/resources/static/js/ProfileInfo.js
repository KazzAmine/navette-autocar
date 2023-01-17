$(()=>{
    splitedURL=document.URL.split("/");
    const [cin]=splitedURL.reverse();
    //getting user infos
    let userInfoJson;
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/Client/getclient/"+cin,
        dataType: "json",
        success:  (response)=> {
             userInfoJson=response
            //setting user informations to inputs
            $("#email").val(userInfoJson["email"]);
            $("#first_name").val(userInfoJson["prenom"]);
            $("#last_name").val(userInfoJson["nom"]);
            $("#ville").val(userInfoJson["ville"]);
            $("#emailLog").val(userInfoJson["email"]);
        },
        async:false
    });
    //update information
    $("#updateInfo").on("click",  ()=> {
        //check if all field are'nt empty
        if($("#last_name").val()!='' && $("#first_name").val()!='' && $("#ville").val()!=''){
            $.ajax({
                type: "PUT",
                url: "http://localhost:8080/Client/updateclient/"+cin,
                data: JSON.stringify({
                        "nom":$("#last_name").val(),
                        "prenom":$("#first_name").val(),
                        "email":$("#email").val(),
                        "ville":$("#ville").val()
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
                "role":"client"
            }),
            dataType: "json",
            contentType:"application/json",
            error:  (jqXHR)=> {
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
            className: "error",
            close:true,
            style: {
              background: "linear-gradient(red, darkred)",
            }
          }).showToast();
    }
    });
    $("#Profile").attr("href", "/clientProfile/"+cin);


    //show current abonnements
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/Abonnement/getabonnementbyclient/"+cin,
        dataType: "json",
        success: function (response) {
            
            if(response.length==0){
                $("#abonnementList").append("<div>vous n'avez aucune abonnement</div>")
            }
            response.forEach(element => {
                // console.log(element)
                $("#abonnementList").append(
                '<tr>'+
                    '<td>'+element.subscription.societe["nom"]+'</td>'+
                    '<td>'+element.subscription["villeDepart"]+'</td>'+
                    '<td>'+element.subscription["villeArrivee"]+'</td>'+
                    '<td>'+element.subscription["heureDepart"]+'</td>'+
                    '<td>'+element.subscription["heureArrive"]+'</td>'+
                    '<td>'+element["depDate"]+'</td>'+
                    '<td>'+element["endDate"]+'</td>'+
                    '<td><button type="button" class="btn btn-outline-danger cancelSubscription" value="'+element["abonnementId"]+'" class="cancelSubscription">annuler NW</button></td>'+
                    '</tr>'
            )
            })
        }
    });
  


})

window.onload=()=>{

  //cancel subscription
  $(".cancelSubscription").on("click",function(){
    
    let deletedId=$(this).val();
    
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/Abonnement/deleteAbonnement/"+deletedId,
        dataType: "json",
        success: (response,jqXHR)=> {
            Toastify({
                text: "deleted!!",
                className: "success",
                close:true,
                style: {
                  background: "linear-gradient(to right,cyan, blue)",
                }
              }).showToast();
        }
    });
})
}