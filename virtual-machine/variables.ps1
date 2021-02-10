$VMName='Ansible Control Node - ArchLinuxVM' # specify name
$Switch='EthExternalSwitch'
$InstallMedia='D:\Hyper-V\Images\archlinux-2021.02.01-x86_64.iso' # change to latest
$VMPath='D:\Hyper-V\Virtual Hard Disks\' # specify other disk location here
$HOSTNAMEVM=(Get-WmiObject -Class Win32_ComputerSystem -Property Name).Name
