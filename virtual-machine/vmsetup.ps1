# dot source variables
. .\variables.ps1

New-VM -Name $VMName -MemoryStartupBytes 1GB -Generation 2 -NewVHDPath "$VMPath\$VMName.vhdx" -NewVHDSizeBytes 128GB -Path "$VMPath" -SwitchName $Switch
Set-VMMemory $VMName -DynamicMemoryEnabled $false 
Set-VMFirmware $VMName -EnableSecureBoot Off
Add-VMDvdDrive -VMName $VMName -ControllerNumber 0 -ControllerLocation 1 -Path $InstallMedia
$DVDDrive=Get-VMDvdDrive -VMName $VMName
Set-VMFirmware -VMName $VMName -FirstBootDevice $DVDDrive
Start-VM -Name $VMName
VMConnect $HOSTNAMEVM $VMName