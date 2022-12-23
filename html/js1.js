function validate()
{
    let form = document.library;
    // if(form.name.value=="")
    // {
    //     alert("Enter the name!");
    //     form.library.focus();
    //     return 
    // }
    if(mobile.length<10||mobile.length>10)
    {
        alert("Enter a valid mobile number!");
        form.library.focus();
        return
    }
    if(form.housenumer.value=="")
    {
        alert("Enter the house number!");
        form.library.focus();
        return
    }
    if(form.street.value=="")
    {
        alert("Enter the street!");
        form.library.focus();
        return
    }
    if(form.pincode.value=="")
    {
        alert("Enter the Pincode!");
        form.library.focus();
        return
    }
}
function copyAddress()
{
   let form = document.library;
    form.phousenumber.value = form.chousenumber.value;
   form.pstreet.value = form.cstreet.value;
   form.ppincode.value = form.cpincode.value;
}


