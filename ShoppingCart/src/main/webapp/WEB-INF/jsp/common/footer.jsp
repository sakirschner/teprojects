<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="footer">
<p>Developed By Scott Kirschner</p>
<p><a href="https://www.linkedin.com/in/scott-kirschner/" target="_blank">LinkedIn</a></p>
<p><a href="https://github.com/sakirschner" target="_blank">GitHub</a></p>
<p>2020</p>
</div>

<%-- grabs an element and changes the display based on click --%>
<script type="text/javascript">
	
function toggle_visibility(id) {
    var e = document.getElementById(id);
    if(e.style.display == 'block')
       e.style.display = 'none';
    else
       e.style.display = 'block';
 }
	
</script>

</body>
</html>