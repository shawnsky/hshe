/**
	A http server of SIM, listen requests to invoke sim_judge.sh and write judge result(%) to response. 
	author: shawnsky
	date: 2018/01/21 21:09
*/
package main
import (
	"fmt"
	"log"
	"net/http"
	"os/exec"
	"bytes"
)

func fuck(w http.ResponseWriter, r *http.Request) {
	r.ParseForm()//parse URL args and update them to r.Form 
	var lang string
	var pid string
	var file0 string
	var file1 string
	var result string = "0"
	lang = r.Form.Get("lang")
	pid = r.Form.Get("pid")
	file0 = r.Form.Get("file0")
	file1 = r.Form.Get("file1")
	s := "/usr/local/hshe/sim_judge.sh "+lang+" "+pid+" "+file0+" "+file1
	fmt.Println("command="+s)//stdprint for debug, remove it later
	/**
	-c string If  the  -c  option  is  present, then commands are read from
          string.  If there are arguments after the  string,  they  are
          assigned to the positional parameters, starting with $0.
	*/
	cmd := exec.Command("/bin/bash", "-c", s)
	var out bytes.Buffer
	var stderr bytes.Buffer
	cmd.Stdout = &out
	cmd.Stderr = &stderr
	err := cmd.Run()
	if err != nil {
		fmt.Println(fmt.Sprint(err) + ": " + stderr.String())
	}
	result = out.String()
	fmt.Fprintf(w, result)
}

func main() {
	http.HandleFunc("/judge", fuck)
	err := http.ListenAndServe(":9090", nil) 
	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}
}