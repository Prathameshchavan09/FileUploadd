


function check() {
        var fileInput = document.getElementById('FileValidator');
        var filePath = fileInput.value;
        var allowedExtensions = /(\.pdf)$/i;

        if (!allowedExtensions.exec(filePath)) {
            alert('Upload Pdf only'); 
        }
    }