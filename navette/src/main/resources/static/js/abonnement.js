
    let container=$("#subs");


    splitedURL=document.URL.split("/")
    const [arrCity,depCity,depTime]=splitedURL.reverse()
    // console.log(arrCity)

    const getSubscriptions=(depTime,depCity,arrCity)=>{
        let retVal;
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/Subscription/getallsubscriptions/"+depTime+"/"+depCity+"/"+arrCity,
            dataType: "JSON",
            success:  (res)=> {
                retVal=res
            },async:false
        });
        return retVal
    }

    

    let retRes=getSubscriptions(depTime,depCity,arrCity)
    retRes.forEach(element => {
        container.append('<div class="row"> <div class="row"> <div class="col-lg-5"><img class="rounded img-fluid" src="/img/tech/image4.jpg"></div><div class="col-lg-7"> <h3 id="prix">'+element.societe["nom"]+'</h3><div class="info"><span id="dateDe"><span id="de"> de : '+element.heureDepart+'</span><span id="aTemp"> a : '+element.heureArrive+'</span><span id="destination"> <br/><span id="depuis">'+element.villeDepart+'  -->  </span><span id="vers">'+element.villeArrivee+'</span></span></div><p id="description" class="text-muted">'+element.description+' </p><button class="btn btn-outline-primary btn-sm btnShowMore" type="button" value="'+element.idSubs+'">subscribe</button></div></div><br/> <br/>')
    });

    $(".btnShowMore").on("click",function(){
        let idSubscription=$(this).val()
        window.location.replace("/subInfo/"+idSubscription)
    });