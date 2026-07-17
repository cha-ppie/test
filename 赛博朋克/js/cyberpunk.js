/* ============================================================
   CYBERPUNK 2077 — SHARED ENGINE
   ============================================================ */

// ===== WEB AUDIO — 赛博朋克氛围合成器 =====
(function(){
    let ctx=null,playing=false;
    const btn=document.getElementById('musicBtn');
    if(!btn)return;

    function createEngine(){
        ctx=new(window.AudioContext||window.webkitAudioContext)();
        const dest=ctx.destination;

        // Deep bass drone
        const bass=ctx.createOscillator();bass.type='sawtooth';bass.frequency.value=55;
        const bg=ctx.createGain();bg.gain.value=0.06;
        const bf=ctx.createBiquadFilter();bf.type='lowpass';bf.frequency.value=200;bf.Q.value=2;
        bass.connect(bf);bf.connect(bg);bg.connect(dest);bass.start();

        // Mid pad
        const pad=ctx.createOscillator();pad.type='triangle';pad.frequency.value=110;
        const pg=ctx.createGain();pg.gain.value=0.04;
        const plfo=ctx.createOscillator();plfo.type='sine';plfo.frequency.value=0.15;
        const plg=ctx.createGain();plg.gain.value=20;
        plfo.connect(plg);plg.connect(pad.frequency);plfo.start();
        pad.connect(pg);pg.connect(dest);pad.start();

        // High shimmer
        const sh=ctx.createOscillator();sh.type='sine';sh.frequency.value=880;
        const sg=ctx.createGain();sg.gain.value=0.015;
        const slfo=ctx.createOscillator();slfo.type='sine';slfo.frequency.value=0.08;
        const slg=ctx.createGain();slg.gain.value=0.008;
        slfo.connect(slg);slg.connect(sg.gain);slfo.start();
        sh.connect(sg);sg.connect(dest);sh.start();

        // Sub-bass rumble
        const rb=ctx.createOscillator();rb.type='sine';rb.frequency.value=28;
        const rg=ctx.createGain();rg.gain.value=0.03;
        rb.connect(rg);rg.connect(dest);rb.start();

        // Glitch percussion
        function glitchHit(){
            const bs=ctx.sampleRate*0.06;
            const buf=ctx.createBuffer(1,bs,ctx.sampleRate);
            const d=buf.getChannelData(0);
            for(let i=0;i<bs;i++)d[i]=(Math.random()*2-1)*Math.exp(-i/(bs*0.15));
            const src=ctx.createBufferSource();src.buffer=buf;
            const g=ctx.createGain();g.gain.value=0.08;
            const f=ctx.createBiquadFilter();f.type='bandpass';f.frequency.value=2000+Math.random()*3000;f.Q.value=0.5;
            src.connect(f);f.connect(g);g.connect(dest);src.start();
        }
        setInterval(()=>{if(playing&&Math.random()<0.3)glitchHit()},3000+Math.random()*5000);
        return ctx;
    }

    btn.addEventListener('click',()=>{
        if(!ctx)ctx=createEngine();
        if(playing){ctx.suspend();btn.classList.remove('playing');btn.querySelector('.icon').textContent='♪';}
        else{ctx.resume();btn.classList.add('playing');btn.querySelector('.icon').textContent='♪';}
        playing=!playing;
    });
})();

// ===== FRAGMENT CANVAS =====
(function(){
    const canvas=document.getElementById('fragmentCanvas');
    if(!canvas)return;
    const ctx=canvas.getContext('2d');
    let W,H,fragments=[],dataStreams=[];

    function resize(){
        W=canvas.width=window.innerWidth;H=canvas.height=window.innerHeight;
        fragments=[];dataStreams=[];
        const fc=Math.floor(W*H/20000);
        const cs=['rgba(252,238,9,','rgba(0,240,255,','rgba(255,0,60,'];
        for(let i=0;i<fc;i++){
            const cx=Math.random()*W,cy=Math.random()*H,sz=Math.random()*40+10;
            const vs=[],nv=Math.floor(Math.random()*4)+3;
            for(let v=0;v<nv;v++){const a=(v/nv)*Math.PI*2+(Math.random()-.5)*.4;const r=sz*(.5+Math.random()*.5);vs.push({x:cx+Math.cos(a)*r,y:cy+Math.sin(a)*r})}
            fragments.push({verts:vs,color:cs[Math.floor(Math.random()*cs.length)],opacity:Math.random()*.035+.01,dx:(Math.random()-.5)*.18,dy:(Math.random()-.5)*.12});
        }
        const dc=Math.floor(W/240);
        const chs='01アイウエオカキクケコABCDEFGHIJKLMNOPQRSTUVWXYZ';
        for(let i=0;i<dc;i++){let s='';for(let j=0;j<Math.floor(Math.random()*20+8);j++)s+=chs[Math.floor(Math.random()*chs.length)];dataStreams.push({x:Math.random()*W,y:Math.random()*H,len:Math.random()*90+40,spd:Math.random()*.16+.05,chars:s,op:Math.random()*.022+.008,clr:Math.random()>.5?'rgba(0,240,255,':'rgba(252,238,9,',fs:Math.random()*5+4})}
    }
    window.addEventListener('resize',resize);

    function draw(){
        ctx.clearRect(0,0,W,H);
        for(let ds of dataStreams){
            ctx.font=ds.fs+'px "Courier New",monospace';
            for(let i=0;i<ds.chars.length;i++){const cy=ds.y+i*ds.fs*1.3;if(cy>-20&&cy<H+20){const a=1-Math.abs((cy-ds.y)/ds.len);if(a>0){ctx.fillStyle=ds.clr+(ds.op*a)+')';ctx.fillText(ds.chars[i],ds.x,cy)}}}
            ds.y+=ds.spd;if(ds.y>H+ds.len){ds.y=-ds.len;ds.x=Math.random()*W}
        }
        for(let f of fragments){
            if(f.verts.length<3)continue;
            ctx.beginPath();ctx.moveTo(f.verts[0].x,f.verts[0].y);
            for(let i=1;i<f.verts.length;i++)ctx.lineTo(f.verts[i].x,f.verts[i].y);
            ctx.closePath();ctx.fillStyle=f.color+f.opacity+')';ctx.fill();
            for(let v of f.verts){v.x+=f.dx;v.y+=f.dy}
            const ax=f.verts.reduce((s,v)=>s+v.x,0)/f.verts.length,ay=f.verts.reduce((s,v)=>s+v.y,0)/f.verts.length;
            if(ax<-100||ax>W+100||ay<-100||ay>H+100){const nx=Math.random()*W,ny=Math.random()*H;for(let v of f.verts){v.x+=nx-ax;v.y+=ny-ay}}
        }
        requestAnimationFrame(draw);
    }
    resize();draw();
})();

// ===== GLITCH BLOCKS =====
(function(){
    const c=document.getElementById('glitchBlocks');
    if(!c)return;
    const cols=['rgba(252,238,9,.05)','rgba(0,240,255,.04)','rgba(255,0,60,.03)'];
    function mk(){
        const b=document.createElement('div');b.className='glitch-block';
        b.style.left=Math.random()*100+'%';b.style.top=Math.random()*100+'%';
        b.style.width=(Math.random()*140+20)+'px';b.style.height=(Math.random()*5+1)+'px';
        b.style.background=cols[Math.floor(Math.random()*cols.length)];
        b.style.animationDuration=(Math.random()*10+8)+'s';b.style.animationDelay=Math.random()*8+'s';
        b.style.transform='skewX('+(Math.random()*28-14)+'deg)';
        c.appendChild(b);setTimeout(()=>{if(b.parentNode)b.remove()},20000);
    }
    for(let i=0;i<15;i++)setTimeout(mk,i*250);
    setInterval(mk,1500);
})();

// ===== NAVIGATION =====
(function(){
    const nav=document.getElementById('nav');
    if(!nav)return;
    window.addEventListener('scroll',()=>nav.classList.toggle('scrolled',window.scrollY>50));
    const mb=document.getElementById('menuBtn'),nm=document.getElementById('navMenu');
    if(mb&&nm){
        mb.addEventListener('click',()=>{mb.classList.toggle('active');nm.classList.toggle('open')});
        document.addEventListener('click',e=>{if(!nm.contains(e.target)&&!mb.contains(e.target)){mb.classList.remove('active');nm.classList.remove('open')}});
    }
    // Active link
    const path=window.location.pathname.split('/').pop()||'index.html';
    document.querySelectorAll('.nav-links a').forEach(a=>{
        const href=a.getAttribute('href');
        if(href===path||(path==='index.html'&&href==='index.html'))a.classList.add('active');
    });
})();

// ===== SCROLL REVEAL =====
(function(){
    const ro=new IntersectionObserver(es=>{es.forEach(e=>{if(e.isIntersecting){e.target.classList.add('visible');ro.unobserve(e.target)}})},{threshold:.15,rootMargin:'0px 0px -40px 0px'});
    document.querySelectorAll('.reveal').forEach(el=>ro.observe(el));
})();

// ===== KEYBOARD: ESC to top =====
document.addEventListener('keydown',e=>{if(e.key==='Escape')window.scrollTo({top:0,behavior:'smooth'})});

console.log('%c CYBERPUNK 2077 %c Never Fade Away','color:#fcee09;font-family:monospace;font-size:16px;','color:#00f0ff;font-family:monospace;');
