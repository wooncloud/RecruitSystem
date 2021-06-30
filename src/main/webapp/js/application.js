let application = {
    init: () => {
        console.log("application init");

        // btn init
        document.getElementById("btnApSave").addEventListener("click", application.save);
        document.getElementById("btnApView").addEventListener("click", application.view);
        document.getElementById("btnApSubmit").addEventListener("click", application.submit);

        // module Init
        application.moduleInit();
    },
    moduleInit: () => {
        // 각 모듈 초기화
        career.init();
        projectExp.init();
        education.init();
        certificate.init();
    },
    save: () => {
        // 지원서 제목
        let title = document.getElementById("txtApTitle");
        // 자기소개
        let introduce = document.getElementById("txtApIntroduce");

        if(title.value == ""){
            swal.fire("알림", "지원서 제목이 없습니다.", "warning");
            title.focus();
            return;
        }
        if(introduce.value == ""){
            swal.fire("알림", "자기소개를 입력해 주세요.", "warning");
            introduce.focus();
            return;
        }

        // json 조합

        // ajsx 전송
    },
    view: () => {
        console.log("view");

        // 몰랑
    },
    submit: () => {
        console.log("submit");

        // 지원할 공고 valid
    },
    delete: (e) => {
        let emt = e.parentElement;

        Swal.fire({
            title: '정말로 삭제 하시겠습니까?',
            showCancelButton: true,
            confirmButtonColor: '#f00',
            confirmButtonText: '삭제',
            cancelButtonText: '취소',
        }).then((result) => {
            if (result.isConfirmed) {
                emt.remove();
            }
        })
    }
}

let recruit = {
    init: () => {

    }
}

let title = {
    init: () => {

    }
}

let career = {
    init: () => {
        document.getElementById("btnCareerAdd").addEventListener("click", career.add);
    },
    reset: () => {
        document.getElementById("txtCareerCorpname").value = "";
        document.getElementById("txtCareerEmploy").value = "";
        document.getElementById("txtCareerPosition").value = "";
        document.getElementById("txtCareerHiredate").value = "";
        document.getElementById("txtCareerFiredate").value = "";
        document.getElementById("txtCareerWork").value = "";
    },
    add: () => {
        let corpname = document.getElementById("txtCareerCorpname");
        let employ = document.getElementById("txtCareerEmploy");
        let position = document.getElementById("txtCareerPosition");
        let hiredate = document.getElementById("txtCareerHiredate");
        let firedate = document.getElementById("txtCareerFiredate");
        let work = document.getElementById("txtCareerWork");

        let data = {
            "corpname": corpname.value,
            "employ": employ.value,
            "position": position.value,
            "hiredate": hiredate.value,
            "firedate": firedate.value,
            "work": work.value
        }

        if(career.valid(data)) {
            let list = document.getElementById("careerList");
            let emt = career.newElement(data);
            list.appendChild(emt);

            career.reset();
        }
        else {
            swal.fire("알림", "누락된 정보가 있습니다.\n다시 확인하세요.", "warning");
            return;
        }
    },
    valid: (data) => {
        if (data.corpname == "") { return false }
        else if (data.employ == "") { return false }
        else if (data.position == "") { return false }
        else if (data.hiredate == "") { return false }
        else if (data.work == "") { return false }
        else { return true }
    },
    newElement: (data) => { 
        let templete = document.getElementById("careerTemplete");
        let emt = document.createElement("div");
        emt.innerHTML = templete.innerText.trim();
        emt.getElementsByTagName("input")[0].value = data.corpname;
        emt.getElementsByTagName("input")[1].value = data.employ;
        emt.getElementsByTagName("input")[2].value = data.position;
        emt.getElementsByTagName("input")[3].value = data.hiredate;
        emt.getElementsByTagName("input")[4].value = data.firedate;
        emt.getElementsByTagName("input")[5].value = data.work;

        return emt;
    },
    modify: (e) => {
        let emt = e.parentElement;
        let inputs = emt.getElementsByTagName("input");
        for (const i of inputs) {
            if(!(i.getAttribute("type") == "button")){
                i.removeAttribute("disabled");
            }
        }

        e.addEventListener("click", () => { career.modified(e) });
        e.setAttribute("value", "저장");
    },
    modified: (e) => {
        let emt = e.parentElement;
        let inputs = emt.getElementsByTagName("input");
        for (const i of inputs) {
            if(!(i.getAttribute("type") == "button")){
                i.setAttribute("disabled", "disabled");
            }
        }

        e.addEventListener("click", () => { career.modify(e) });
        e.setAttribute("value", "수정");
    }
}

let projectExp = {
    init: () => {
        document.getElementById("btnProjectExpAdd").addEventListener("click", projectExp.add);
    },
    reset: () => {
        document.getElementById("txtProjectExpTitle").value = "";
        document.getElementById("txtProjectExpStartdate").value = "";
        document.getElementById("txtProjectExpEnddate").value = "";
        document.getElementById("txtProjectExpCorpname").value = "";
        document.getElementById("txtProjectExpJob").value = "";
        document.getElementById("txtProjectExpContent").value = "";
    },
    add: () => {
        let title = document.getElementById("txtProjectExpTitle");
        let startdate = document.getElementById("txtProjectExpStartdate");
        let enddate = document.getElementById("txtProjectExpEnddate");
        let corpname = document.getElementById("txtProjectExpCorpname");
        let job = document.getElementById("txtProjectExpJob");
        let content = document.getElementById("txtProjectExpContent");

        let data = {
            "Title": title.value,
            "Startdate": startdate.value,
            "Enddate": enddate.value,
            "Corpname": corpname.value,
            "Job": job.value,
            "Content": content.value
        }

        if(projectExp.valid(data)) {
            let list = document.getElementById("projectExpList");
            let emt = projectExp.newElement(data);
            list.appendChild(emt);

            projectExp.reset();
        }
        else {
            swal.fire("알림", "누락된 정보가 있습니다.\n다시 확인하세요.", "warning");
            return;
        }
    },
    valid: (data) => {
        if (data.title == "") { return false }
        else if (data.startdate == "") { return false }
        else if (data.corpname == "") { return false }
        else if (data.job == "") { return false }
        else if (data.content == "") { return false }
        else { return true }
    },
    newElement: (data) => { 
        let templete = document.getElementById("projectExpTemplete");
        let emt = document.createElement("div");
        emt.innerHTML = templete.innerText.trim();
        emt.getElementsByTagName("input")[0].value = data.Title;
        emt.getElementsByTagName("input")[1].value = data.Startdate;
        emt.getElementsByTagName("input")[2].value = data.Enddate;
        emt.getElementsByTagName("input")[3].value = data.Corpname;
        emt.getElementsByTagName("input")[4].value = data.Job;
        emt.getElementsByTagName("textarea")[0].value = data.Content;

        return emt;
    },
    modify: (e) => {
        let emt = e.parentElement;
        emt.getElementsByTagName("textarea")[0].removeAttribute("disabled");
        let inputs = emt.getElementsByTagName("input");
        for (const i of inputs) {
            if(!(i.getAttribute("type") == "button")){
                i.removeAttribute("disabled");
            }
        }

        e.addEventListener("click", () => { projectExp.modified(e) });
        e.setAttribute("value", "저장");
    },
    modified: (e) => {
        let emt = e.parentElement;
        emt.getElementsByTagName("textarea")[0].setAttribute("disabled", "disabled");
        let inputs = emt.getElementsByTagName("input");
        for (const i of inputs) {
            if(!(i.getAttribute("type") == "button")){
                i.setAttribute("disabled", "disabled");
            }
        }

        e.addEventListener("click", () => { projectExp.modify(e) });
        e.setAttribute("value", "수정");
    }
}

let introduce = {
    init: () => {

    }
}

let portpolio = {
    init: () => {

    }
}

let education = {
    init: () => {
        document.getElementById("btnEducationAdd").addEventListener("click", education.add);
    },
    reset: () => {
        document.getElementById("selEduFinaledu").value = "";
        document.getElementById("txtEduName").value = "";
        document.getElementById("txtEduMajor").value = "";
        document.getElementById("txtEduScore").value = "";
        document.getElementById("txtEduIndate").value = "";
        document.getElementById("txtEduOutdate").value = "";
        document.getElementById("selEduStatus").value = "";
    },
    add: () => {
        let finaledu = document.getElementById("selEduFinaledu");
        let name = document.getElementById("txtEduName");
        let major = document.getElementById("txtEduMajor");
        let score = document.getElementById("txtEduScore");
        let indate = document.getElementById("txtEduIndate");
        let outdate = document.getElementById("txtEduOutdate");
        let status = document.getElementById("selEduStatus");

        let data = {
            "finaledu": finaledu.value,
            "name": name.value,
            "major": major.value,
            "score": score.value,
            "indate": indate.value,
            "outdate": outdate.value,
            "status": status.value
        }

        if(education.valid(data)) {
            let list = document.getElementById("educationList");
            let emt = education.newElement(data);
            list.appendChild(emt);

            education.reset();
        }
        else {
            swal.fire("알림", "누락된 정보가 있습니다.\n다시 확인하세요.", "warning");
            return;
        }
    },
    valid: (data) => {
        
        if (data.finaledu == "") { return false }
        else if (data.name == "") { return false }
        else if (data.major == "") { return false }
        else if (data.score == "") { return false }
        else if (data.indate == "") { return false }
        else if (data.status == "") { return false }
        else { return true }
    },
    newElement: (data) => { 
        let templete = document.getElementById("educationTemplete");
        let emt = document.createElement("div");
        emt.innerHTML = templete.innerText.trim();
        emt.getElementsByTagName("select")[0].value = data.finaledu;
        emt.getElementsByTagName("input")[0].value = data.name;
        emt.getElementsByTagName("input")[1].value = data.major;
        emt.getElementsByTagName("input")[2].value = data.score;
        emt.getElementsByTagName("input")[3].value = data.indate;
        emt.getElementsByTagName("input")[4].value = data.outdate;
        emt.getElementsByTagName("select")[1].value = data.status;

        return emt;
    },
    modify: (e) => {
        let emt = e.parentElement;
        let inputs = emt.getElementsByTagName("input");
        for (const i of inputs) {
            if(!(i.getAttribute("type") == "button")){
                i.removeAttribute("disabled");
            }
        }
        emt.getElementsByTagName("select")[0].removeAttribute("disabled");
        emt.getElementsByTagName("select")[1].removeAttribute("disabled");
        e.addEventListener("click", () => { education.modified(e) });
        e.setAttribute("value", "저장");
    },
    modified: (e) => {
        let emt = e.parentElement;
        let inputs = emt.getElementsByTagName("input");
        for (const i of inputs) {
            if(!(i.getAttribute("type") == "button")){
                i.setAttribute("disabled", "disabled");
            }
        }
        emt.getElementsByTagName("select")[0].setAttribute("disabled", "disabled");
        emt.getElementsByTagName("select")[1].setAttribute("disabled", "disabled");
        e.addEventListener("click", () => { education.modify(e) });
        e.setAttribute("value", "수정");
    }
}

let certificate = {
    init: () => {
        document.getElementById("btnCertificateAdd").addEventListener("click", certificate.add);
    },
    reset: () => {
        document.getElementById("selCertType").value = "";
        document.getElementById("txtCertName").value = "";
        document.getElementById("txtCertAgency").value = "";
        document.getElementById("txtCertGrade").value = "";
        document.getElementById("txtCertRegdate").value = "";
    },
    add: () => {
        let type = document.getElementById("selCertType");
        let name = document.getElementById("txtCertName");
        let agency = document.getElementById("txtCertAgency");
        let grade = document.getElementById("txtCertGrade");
        let regdate = document.getElementById("txtCertRegdate");

        let data = {
            "type": type.value,
            "name": name.value,
            "agency": agency.value,
            "grade": grade.value,
            "regdate": regdate.value
        }

        if(certificate.valid(data)) {
            let certList = document.getElementById("certList");
            let emt = certificate.newElement(data);
            certList.appendChild(emt);

            certificate.reset();
        }
        else {
            swal.fire("알림", "누락된 정보가 있습니다.\n다시 확인하세요.", "warning");
            return;
        }
    },
    valid: (data) => {
        if (data.name == "") { return false }
        else if (data.agency == "") { return false }
        else if (data.grade == "") { return false }
        else if (data.regdate == "") { return false }
        else { return true }
    },
    newElement:(data) => {
        let templete = document.getElementById("certTemplete");
        let emt = document.createElement("div");
        emt.innerHTML = templete.innerText.trim();
        emt.getElementsByTagName("select")[0].value = data.type;
        emt.getElementsByTagName("input")[0].value = data.name;
        emt.getElementsByTagName("input")[1].value = data.agency;
        emt.getElementsByTagName("input")[2].value = data.grade;
        emt.getElementsByTagName("input")[3].value = data.regdate;

        return emt;
    },
    modify: (e) => {
        let emt = e.parentElement;
        emt.getElementsByTagName("select")[0].removeAttribute("disabled");
        let inputs = emt.getElementsByTagName("input");
        for (const i of inputs) {
            i.removeAttribute("disabled");
        }

        e.addEventListener("click", () => { certificate.modified(e) });
        e.setAttribute("value", "저장");
    },
    modified: (e) => {
        let emt = e.parentElement;
        emt.getElementsByTagName("select")[0].setAttribute("disabled", "disabled");
        let inputs = emt.getElementsByTagName("input");
        for (const i of inputs) {
            if(!(i.getAttribute("type") == "button")){
                i.setAttribute("disabled", "disabled");
            }
        }

        e.addEventListener("click", () => { certificate.modify(e) });
        e.setAttribute("value", "수정");
    }
}

let military = {
    init: () => {

    }
}

let rewarding = {
    init: () => {

    }
}

let handicap = {
    init: () => {

    }
}