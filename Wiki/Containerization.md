Foundations are essential and one such foundation for becoming a successful 

engineer in DevOps is having a solid foundation of containerization.


𝟭. 𝗪𝗵𝗮𝘁 𝗮𝗿𝗲 𝗰𝗼𝗻𝘁𝗮𝗶𝗻𝗲𝗿𝘀
 
Containers are lightweight and portable software packages that combine an application and its dependencies, such as libraries, frameworks, and settings, into a single executable unit. They provide a consistent and reliable way to deploy applications across different environments.
 
𝟮. 𝗪𝗵𝘆 𝗱𝗶𝗱 𝘄𝗲 𝗶𝗻𝘃𝗲𝗻𝘁 𝗰𝗼𝗻𝘁𝗮𝗶𝗻𝗲𝗿𝘀
 
Containers have been around since the 1970s and are used in various ways. They were earlier implemented as part of Unix to better isolate the application code.

Software containers have their roots in the 1970s and 1980s with the development of chroot and Unix containers. 

In 2008, LXC (Linux Containers) was released, providing a lightweight and portable way to run multiple isolated systems on a single host. Docker made it easy with containerization and popular
 
𝟯. 𝗪𝗵𝘆 𝘄𝗲 𝗻𝗲𝗲𝗱 𝗰𝗼𝗻𝘁𝗮𝗶𝗻𝗲𝗿𝘀 ?
 
We need containers because they provide a solution to several challenges in software development and deployment, some of which are : Consistency, isolation, portability, scalability, efficiency, speed to deploy, improved security,
 
𝟰. 𝗜𝘀 𝗱𝗼𝗰𝗸𝗲𝗿 𝘁𝗵𝗲 𝗼𝗻𝗹𝘆 𝗰𝗼𝗻𝘁𝗮𝗶𝗻𝗲𝗿?
 
Docker, while the most popular, is not the sole container solution. The market offers a variety of options, including rkt, runc, OCI, LXD, Podman, and containerd, each with its unique features and benefits.
 
𝟱. 𝗪𝗵𝗮𝘁 𝗮𝗿𝗲 𝗽𝗿𝗼𝘀 𝗮𝗻𝗱 𝗰𝗼𝗻𝘀 𝗼𝗳 𝗰𝗼𝗻𝘁𝗮𝗶𝗻𝗲𝗿
 Pros - Consistency, isolation, portability, scalability, efficiency, speed to deploy, improved security
 Cons - Orchestration complexity, Persistent storage, Monitoring / logging, Networking complexity
 
 
𝟴. 𝗪𝗵𝗮𝘁 𝗶𝘀 𝗢𝗖𝗜 𝗮𝗻𝗱 𝗵𝗼𝘄 𝗶𝘀 𝘁𝗵𝗮𝘁 𝗰𝗵𝗮𝗻𝗴𝗶𝗻𝗴 -
 
The Open Container Initiative (OCI) is a game-changer in the world of containerization. It's an open standard that aims to establish a common, vendor-neutral format for containers.
 
𝟵.  𝗦𝗶𝗺𝗽𝗹𝗲𝘀𝘁 𝗘𝘅𝗮𝗺𝗽𝗹𝗲 𝗼𝗳 𝗖𝗼𝗻𝘁𝗮𝗶𝗻𝗲𝗿 𝗜𝗺𝗽𝗹𝗲𝗺𝗲𝗻𝘁𝗮𝘁𝗶𝗼𝗻 𝗶𝗻 𝗟𝗶𝗻𝘂𝘅
 
Install LXC, Create a Container, Run & Access, Delete and exit

 LCX - Create a new namespace --> LCX - sets up cgroups to manage the container's resources. --> LXC - creates a new chroot environment for the container.

 LCX switches the container's root filesystem using pivot_root. --> LCX starts the container's init process (e.g., /sbin/init). --> The container runs isolated from the host system, with its own resources and processes.
 
𝟭𝟬. 𝗛𝗼𝘄 𝗰𝗼𝗻𝘁𝗮𝗶𝗻𝗲𝗿𝘀 𝗮𝗿𝗲 𝗰𝗿𝗲𝗮𝘁𝗲𝗱 𝗶𝗻 𝗹𝗶𝗻𝘂𝘅 
Namespace ( PID, NET, MNT, user, UTS) - Cgroups(CPU, memory, I/O, Network) - File Systems (/proc) - Container Run time - System Calls
 
You can create containers without Docker, but you need to have knowledge of - Processes, Namespaces, cgroups, chroot, syscalls

![image](https://github.com/user-attachments/assets/ae4650dc-6160-4bf4-98ca-6f56ada77b28)

Source/Credit: https://www.linkedin.com/posts/maheshma_devops-activity-7289817165283635202-0Pmc?utm_source=share&utm_medium=member_desktop
